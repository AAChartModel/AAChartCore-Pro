package com.aachartmodel.aachartcore_pro.AAStageSeries;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ScrollView;

import com.aachartmodel.aachartcore_pro.R;
import com.aachartmodel.aachartcore_pro.datasource.AAOptionsData;
import com.aachartmodel.aacharts.aachartcreator.AAChartView;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAEnvelope;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 自定义阶段图表演示Activity
 * 展示睡眠阶段可视化图表，支持多种参数调整
 */
public class AACustomStageChartActivity extends AppCompatActivity {

    private AAChartView aaChartView;
    private AAOptions aaOptions;

    // 控制参数
    private String currentMode = "connect";
    private boolean arcsEnabled = true;
    private String arcsMode = "concave";
    private float barRadius = 12.0f;
    private float margin = 8.0f;
    private float externalRadius = 18.0f;
    private float opacity = 0.38f;
    private float seamEpsilon = 0.5f;
    private int sleepSegments = 25;
    private boolean fixedGradient = true;

    private String[][] currentDataset = null;

    // UI 控件
    private RadioGroup modeRadioGroup;
    private CheckBox arcsCheckBox;
    private RadioGroup arcsModeRadioGroup;
    private SeekBar barRadiusSeekBar;
    private SeekBar marginSeekBar;
    private SeekBar externalRadiusSeekBar;
    private SeekBar opacitySeekBar;
    private SeekBar seamEpsilonSeekBar;
    private SeekBar sleepSegmentsSeekBar;
    private CheckBox fixedGradientCheckBox;

    private TextView barRadiusValue;
    private TextView marginValue;
    private TextView externalRadiusValue;
    private TextView opacityValue;
    private TextView seamEpsilonValue;
    private TextView sleepSegmentsValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_stage_chart);

        setTitle("Custom Stage Chart");

        initViews();
        setupChartView();
        setupControls();
    }

    private void initViews() {
        aaChartView = findViewById(R.id.aa_chart_view);

        modeRadioGroup = findViewById(R.id.mode_radio_group);
        arcsCheckBox = findViewById(R.id.arcs_checkbox);
        arcsModeRadioGroup = findViewById(R.id.arcs_mode_radio_group);

        barRadiusSeekBar = findViewById(R.id.bar_radius_seekbar);
        marginSeekBar = findViewById(R.id.margin_seekbar);
        externalRadiusSeekBar = findViewById(R.id.external_radius_seekbar);
        opacitySeekBar = findViewById(R.id.opacity_seekbar);
        seamEpsilonSeekBar = findViewById(R.id.seam_epsilon_seekbar);
        sleepSegmentsSeekBar = findViewById(R.id.sleep_segments_seekbar);
        fixedGradientCheckBox = findViewById(R.id.fixed_gradient_checkbox);

        barRadiusValue = findViewById(R.id.bar_radius_value);
        marginValue = findViewById(R.id.margin_value);
        externalRadiusValue = findViewById(R.id.external_radius_value);
        opacityValue = findViewById(R.id.opacity_value);
        seamEpsilonValue = findViewById(R.id.seam_epsilon_value);
        sleepSegmentsValue = findViewById(R.id.sleep_segments_value);

        Button fluidPresetBtn = findViewById(R.id.preset_fluid);
        Button parityPresetBtn = findViewById(R.id.preset_parity);
        Button safeDilatePresetBtn = findViewById(R.id.preset_safe_dilate);
        Button ultraCrispPresetBtn = findViewById(R.id.preset_ultra_crisp);
        Button randomDataBtn = findViewById(R.id.random_data);

        // 预设按钮点击事件
        fluidPresetBtn.setOnClickListener(v -> applyPreset(AACustomStageChartComposer.PresetType.FLUID));
        parityPresetBtn.setOnClickListener(v -> applyPreset(AACustomStageChartComposer.PresetType.PARITY));
        safeDilatePresetBtn.setOnClickListener(v -> applyPreset(AACustomStageChartComposer.PresetType.SAFE_DILATE));
        ultraCrispPresetBtn.setOnClickListener(v -> applyPreset(AACustomStageChartComposer.PresetType.ULTRA_CRISP));
        randomDataBtn.setOnClickListener(v -> generateRandomData());
    }

    private void setupChartView() {
//        aaChartView.setScrollEnabled(false);

        // 配置插件路径
        // 注意:使用相对于assets目录的路径,不要使用file:///android_asset/前缀
        Set<String> pluginPaths = Set.of(
            "AAModules/AAXrange.js",    // 使用aacharts module中的AAXrange.js,避免重复
            "AACustom-Stage.js"         // app module中的自定义插件
        );
        aaChartView.userPluginPaths = pluginPaths;

        // 配置插件依赖关系 - 非常重要!决定了JS插件的加载顺序
        // AACustom-Stage.js 依赖于 AAXrange.js,必须先加载 AAXrange.js
        // 注意:依赖关系的值应该是文件名(不含路径),比较时会自动提取文件名
        Map<String, String> pluginDependencies = new HashMap<>();
        pluginDependencies.put("AACustom-Stage.js", "AAXrange.js");  // 使用文件名,不是完整路径
        aaChartView.dependencies = pluginDependencies;

        // 创建默认图表
        aaOptions = AACustomStageChartComposer.defaultOptions();
        aaChartView.aa_drawChartWithChartOptions(aaOptions);
    }

    private void setupControls() {
        // Mode选择
        modeRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.mode_connect) {
                currentMode = "connect";
            } else if (checkedId == R.id.mode_dilate) {
                currentMode = "dilate";
            }
            updateChart();
        });

        // Arcs开关
        arcsCheckBox.setChecked(arcsEnabled);
        arcsCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            arcsEnabled = isChecked;
            updateChart();
        });

        // Arcs Mode选择
        arcsModeRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.arcs_mode_concave) {
                arcsMode = "concave";
            } else if (checkedId == R.id.arcs_mode_convex) {
                arcsMode = "convex";
            }
            updateChart();
        });

        // Bar Radius
        barRadiusSeekBar.setMax(2000); // 0-20, step 0.01
        barRadiusSeekBar.setProgress((int) (barRadius * 100));
        barRadiusValue.setText(String.format("%.2f", barRadius));
        barRadiusSeekBar.setOnSeekBarChangeListener(new SeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                barRadius = progress / 100.0f;
                barRadiusValue.setText(String.format("%.2f", barRadius));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateChart();
            }
        });

        // Margin
        marginSeekBar.setMax(2000); // 0-20, step 0.01
        marginSeekBar.setProgress((int) (margin * 100));
        marginValue.setText(String.format("%.2f", margin));
        marginSeekBar.setOnSeekBarChangeListener(new SeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                margin = progress / 100.0f;
                marginValue.setText(String.format("%.2f", margin));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateChart();
            }
        });

        // External Radius
        externalRadiusSeekBar.setMax(3000); // 0-30, step 0.01
        externalRadiusSeekBar.setProgress((int) (externalRadius * 100));
        externalRadiusValue.setText(String.format("%.2f", externalRadius));
        externalRadiusSeekBar.setOnSeekBarChangeListener(new SeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                externalRadius = progress / 100.0f;
                externalRadiusValue.setText(String.format("%.2f", externalRadius));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateChart();
            }
        });

        // Opacity
        opacitySeekBar.setMax(100); // 0-1, step 0.01
        opacitySeekBar.setProgress((int) (opacity * 100));
        opacityValue.setText(String.format("%.2f", opacity));
        opacitySeekBar.setOnSeekBarChangeListener(new SeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                opacity = progress / 100.0f;
                opacityValue.setText(String.format("%.2f", opacity));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateChart();
            }
        });

        // Seam Epsilon
        seamEpsilonSeekBar.setMax(200); // 0-2, step 0.01
        seamEpsilonSeekBar.setProgress((int) (seamEpsilon * 100));
        seamEpsilonValue.setText(String.format("%.2f", seamEpsilon));
        seamEpsilonSeekBar.setOnSeekBarChangeListener(new SeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seamEpsilon = progress / 100.0f;
                seamEpsilonValue.setText(String.format("%.2f", seamEpsilon));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateChart();
            }
        });

        // Sleep Segments
        sleepSegmentsSeekBar.setMax(92); // 8-100
        sleepSegmentsSeekBar.setProgress(sleepSegments - 8);
        sleepSegmentsValue.setText(String.valueOf(sleepSegments));
        sleepSegmentsSeekBar.setOnSeekBarChangeListener(new SeekBarListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sleepSegments = progress + 8;
                sleepSegmentsValue.setText(String.valueOf(sleepSegments));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 不在这里更新图表，只在点击Random Data时生成新数据
            }
        });

        // Fixed Gradient
        fixedGradientCheckBox.setChecked(fixedGradient);
        fixedGradientCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            fixedGradient = isChecked;
            updateChart();
        });
    }

    private void updateChart() {
        AAEnvelope envelope = AACustomStageChartComposer.createEnvelopeConfig(
                currentMode,
                arcsEnabled,
                arcsMode,
                margin,
                externalRadius,
                opacity,
                seamEpsilon,
                fixedGradient
        );

        AAOptions updatedOptions = AACustomStageChartComposer.updateStageChartOptions(
                aaOptions,
                currentDataset,
                envelope,
                barRadius
        );

        aaChartView.aa_refreshChartWithChartOptions(updatedOptions);
    }

    private void generateRandomData() {
        currentDataset = AAOptionsData.randomSleepData(sleepSegments);
        updateChart();
    }

    private void applyPreset(AACustomStageChartComposer.PresetType preset) {
        switch (preset) {
            case FLUID:
                currentMode = "connect";
                arcsEnabled = true;
                arcsMode = "concave";
                margin = 8.0f;
                externalRadius = 18.0f;
                opacity = 0.38f;
                seamEpsilon = 0.5f;
                barRadius = 12.0f;
                sleepSegments = 20;
                fixedGradient = true;
                break;
            case PARITY:
                currentMode = "connect";
                arcsEnabled = false;
                arcsMode = "concave";
                margin = 10.0f;
                externalRadius = 24.0f;
                opacity = 0.45f;
                seamEpsilon = 1.0f;
                barRadius = 8.0f;
                sleepSegments = 30;
                fixedGradient = true;
                break;
            case SAFE_DILATE:
                currentMode = "dilate";
                arcsEnabled = false;
                arcsMode = "concave";
                margin = 10.0f;
                externalRadius = 16.0f;
                opacity = 0.42f;
                seamEpsilon = 0.6f;
                barRadius = 6.0f;
                sleepSegments = 15;
                fixedGradient = true;
                break;
            case ULTRA_CRISP:
                currentMode = "connect";
                arcsEnabled = false;
                arcsMode = "concave";
                margin = 5.0f;
                externalRadius = 2.0f;
                opacity = 0.38f;
                seamEpsilon = 0.0f;
                barRadius = 3.0f;
                sleepSegments = 80;
                fixedGradient = true;
                break;
        }

        // 更新UI控件
        syncControlsWithState();
        updateChart();
    }

    private void syncControlsWithState() {
        // 更新所有控件以反映当前状态
        if (currentMode.equals("connect")) {
            modeRadioGroup.check(R.id.mode_connect);
        } else {
            modeRadioGroup.check(R.id.mode_dilate);
        }

        arcsCheckBox.setChecked(arcsEnabled);

        if (arcsMode.equals("concave")) {
            arcsModeRadioGroup.check(R.id.arcs_mode_concave);
        } else {
            arcsModeRadioGroup.check(R.id.arcs_mode_convex);
        }

        barRadiusSeekBar.setProgress((int) (barRadius * 100));
        barRadiusValue.setText(String.format("%.2f", barRadius));

        marginSeekBar.setProgress((int) (margin * 100));
        marginValue.setText(String.format("%.2f", margin));

        externalRadiusSeekBar.setProgress((int) (externalRadius * 100));
        externalRadiusValue.setText(String.format("%.2f", externalRadius));

        opacitySeekBar.setProgress((int) (opacity * 100));
        opacityValue.setText(String.format("%.2f", opacity));

        seamEpsilonSeekBar.setProgress((int) (seamEpsilon * 100));
        seamEpsilonValue.setText(String.format("%.2f", seamEpsilon));

        sleepSegmentsSeekBar.setProgress(sleepSegments - 8);
        sleepSegmentsValue.setText(String.valueOf(sleepSegments));

        fixedGradientCheckBox.setChecked(fixedGradient);
    }

    // SeekBar监听器基类
    private abstract static class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
