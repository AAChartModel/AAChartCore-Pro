/**
 * AAChartViewPluginProvider.java
 * AAChartCore
 *
 * Created by AnAn on 2025/10/3.
 * Copyright © 2025年 An An. All rights reserved.
 *
 * ◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉ ...... SOURCE CODE ......◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉
 * ◉◉◉...................................................       ◉◉◉
 * ◉◉◉   https://github.com/AAChartModel/AAChartCore            ◉◉◉
 * ◉◉◉   https://github.com/AAChartModel/AAChartCore-Kotlin     ◉◉◉
 * ◉◉◉...................................................       ◉◉◉
 * ◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉ ...... SOURCE CODE ......◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉◉
 *
 * -------------------------------------------------------------------------------
 *
 *  🌕 🌖 🌗 🌘  ❀❀❀   WARM TIPS!!!   ❀❀❀ 🌑 🌒 🌓 🌔
 *
 * Please contact me on GitHub,if there are any problems encountered in use.
 * GitHub Issues : https://github.com/AAChartModel/AAChartCore/issues
 * -------------------------------------------------------------------------------
 * And if you want to contribute for this project, please contact me as well
 * GitHub        : https://github.com/AAChartModel
 * StackOverflow : https://stackoverflow.com/users/7842508/codeforu
 * JianShu       : http://www.jianshu.com/u/f1e6753d4254
 * SegmentFault  : https://segmentfault.com/u/huanghunbieguan
 *
 * -------------------------------------------------------------------------------
 */

package com.aachartmodel.aacharts.aachartcreator;

import android.content.Context;
import android.util.Log;

import com.aachartmodel.aacharts.aachartenum.AAChartType;
import com.aachartmodel.aacharts.aaoptionsmodel.AAOptions;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// MARK: - Shared Plugin Script Definition

/**
 * Enum representing all available plugin scripts
 */
enum AAChartPluginScriptType {
    // AAInfographics normal version plugins
    HIGHCHARTS_MORE("AAHighcharts-More", "AAMaster"),
    FUNNEL("AAFunnel", "AAMaster"),
    
    // AAInfographics pro version plugins
    SANKEY("AASankey", "AAModules"),
    DEPENDENCY_WHEEL("AADependency-Wheel", "AAModules"),
    NETWORKGRAPH("AANetworkgraph", "AAModules"),
    ORGANIZATION("AAOrganization", "AAModules"),
    ARC_DIAGRAM("AAArc-Diagram", "AAModules"),
    VENN("AAVenn", "AAModules"),
    TREEMAP("AATreemap", "AAModules"),
    SUNBURST("AASunburst", "AAModules"),
    FLAME("AAFlame", "AAModules"),
    VARIABLE_PIE("AAVariable-Pie", "AAModules"),
    VARIWIDE("AAVariwide", "AAModules"),
    DUMBBELL("AADumbbell", "AAModules"),
    LOLLIPOP("AALollipop", "AAModules"),
    HISTOGRAM_BELLCURVE("AAHistogram-Bellcurve", "AAModules"),
    BULLET("AABullet", "AAModules"),
    HEATMAP("AAHeatmap", "AAModules"),
    TILEMAP("AATilemap", "AAModules"),
    STREAMGRAPH("AAStreamgraph", "AAModules"),
    XRANGE("AAXrange", "AAModules"),
    TIMELINE("AATimeline", "AAModules"),
    SOLID_GAUGE("AASolid-Gauge", "AAModules"),
    VECTOR("AAVector", "AAModules"),
    ITEM_SERIES("AAItem-Series", "AAModules"),
    DATA_GROUPING("AADatagrouping", "AAModules"),
    WINDBARB("AAWindbarb", "AAModules"),
    WORDCLOUD("AAWordcloud", "AAModules"),
    TREEGRAPH("AATreegraph", "AAModules"),
    PICTORIAL("AAPictorial", "AAModules"),
    PARALLEL_COORDINATES("AAParallel-Coordinates", "AAModules"),
    DATA("AAData", "AAModules");

    private final String rawValue;
    private final String directoryPrefix;

    AAChartPluginScriptType(String rawValue, String directoryPrefix) {
        this.rawValue = rawValue;
        this.directoryPrefix = directoryPrefix;
    }

    public String getRawValue() {
        return rawValue;
    }

    /**
     * Returns the complete JavaScript file name with .js extension
     */
    public String getFileName() {
        return rawValue + ".js";
    }

    /**
     * Returns the directory prefix for the plugin script
     * Highcharts-More and Funnel are in AAMaster, others are in AAModules
     */
    public String getDirectoryPrefix() {
        return directoryPrefix;
    }
}

// MARK: - Plugin Provider Protocol

/**
 * Protocol defining the responsibility for providing required plugin paths
 */
interface AAChartViewPluginProviderProtocol {
    Set<String> getRequiredPluginPaths(AAOptions options);
}

// MARK: - Default Plugin Provider

/**
 * Default provider (can be used for the standard version or as a base)
 */
class AAChartViewDefaultPluginProvider implements AAChartViewPluginProviderProtocol {
    public AAChartViewDefaultPluginProvider() {}

    @Override
    public Set<String> getRequiredPluginPaths(AAOptions options) {
        return new HashSet<>();
    }
}

// MARK: - Plugin Provider for Standard Version

/**
 * Provider for the standard version, handling specific chart type plugins
 */
public class AAChartViewPluginProvider implements AAChartViewPluginProviderProtocol {
    private final AAChartBundlePathLoadingProtocol bundlePathLoader;

    public AAChartViewPluginProvider(Context context) {
        this.bundlePathLoader = new BundlePathLoader(context);
    }

    public AAChartViewPluginProvider(AAChartBundlePathLoadingProtocol bundlePathLoader) {
        this.bundlePathLoader = bundlePathLoader;
    }

    /**
     * Plugin configuration structure
     */
    private static class AAChartPluginConfiguration {
        final Set<String> types;
        final List<AAChartPluginScriptType> scripts;

        AAChartPluginConfiguration(String[] types, AAChartPluginScriptType[] scripts) {
            this.types = new HashSet<>(Arrays.asList(types));
            this.scripts = Arrays.asList(scripts);
        }
    }

    /**
     * Plugin configurations for Pro version chart types
     */
    private static final List<AAChartPluginConfiguration> pluginConfigurations = Arrays.asList(
        // --- Advanced Charts requiring Highcharts-More ---
        new AAChartPluginConfiguration(
            new String[] {
                AAChartType.Columnpyramid,
                AAChartType.Bubble,
                AAChartType.Packedbubble,
                AAChartType.Arearange,
                AAChartType.Areasplinerange,
                AAChartType.Columnrange,
                AAChartType.Gauge,
                AAChartType.Boxplot,
                AAChartType.Errorbar,
                AAChartType.Waterfall,
                AAChartType.Polygon
            },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.HIGHCHARTS_MORE }
        ),
        
        // --- Funnel & Pyramid Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Funnel, AAChartType.Pyramid },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.FUNNEL }
        ),
        
        // --- Flow & Relationship Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Sankey },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.SANKEY }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Dependencywheel },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.SANKEY, AAChartPluginScriptType.DEPENDENCY_WHEEL }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Networkgraph },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.NETWORKGRAPH }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Organization },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.SANKEY, AAChartPluginScriptType.ORGANIZATION }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Arcdiagram },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.SANKEY, AAChartPluginScriptType.ARC_DIAGRAM }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Venn },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.VENN }
        ),

        // --- Hierarchical Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Treemap },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.TREEMAP }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Sunburst },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.SUNBURST }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Flame },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.FLAME }
        ),

        // --- Distribution & Comparison Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Variablepie },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.VARIABLE_PIE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Variwide },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.VARIWIDE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Dumbbell },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.DUMBBELL }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Lollipop },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.DUMBBELL, AAChartPluginScriptType.LOLLIPOP }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Histogram },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.HISTOGRAM_BELLCURVE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Bellcurve },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.HISTOGRAM_BELLCURVE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Bullet },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.BULLET }
        ),

        // --- Heatmap & Matrix Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Heatmap },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.HEATMAP }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Tilemap },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.HEATMAP, AAChartPluginScriptType.TILEMAP }
        ),

        // --- Time, Range & Stream Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Streamgraph },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.STREAMGRAPH }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Xrange },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.XRANGE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Timeline },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.TIMELINE }
        ),

        // --- Gauge & Indicator Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Solidgauge },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.SOLID_GAUGE }
        ),

        // --- Specialized & Other Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Vector },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.VECTOR }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Item },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.ITEM_SERIES }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Windbarb },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.DATA_GROUPING, AAChartPluginScriptType.WINDBARB }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Wordcloud },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.WORDCLOUD }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Treegraph },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.TREEMAP, AAChartPluginScriptType.TREEGRAPH }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Pictorial },
            new AAChartPluginScriptType[] { AAChartPluginScriptType.PICTORIAL }
        )
    );

    @Override
    public Set<String> getRequiredPluginPaths(AAOptions options) {
        Set<String> requiredPaths = new HashSet<>();

        // Check for plugins based on AAOptions properties
        addChartPluginScripts(options, requiredPaths);

        // Check for plugins based on the main chart type
        if (options.chart != null && options.chart.type != null) {
            addChartPluginScripts(options.chart.type, requiredPaths);
        }

        // Check for plugins based on individual series types
        if (options.series != null) {
            for (Object seriesElement : options.series) {
                if (seriesElement instanceof AASeriesElement) {
                    AASeriesElement element = (AASeriesElement) seriesElement;
                    String seriesType = element.type;
                    if (seriesType != null) {
                        addChartPluginScripts(seriesType, requiredPaths);
                    }
                }
            }
        }

        return requiredPaths;
    }

    /**
     * Helper to add scripts based on chart type string
     */
    private void addChartPluginScripts(String chartType, Set<String> requiredPaths) {
        if (chartType == null) {
            return;
        }

        Set<AAChartPluginScriptType> scripts = new HashSet<>();
        for (AAChartPluginConfiguration configuration : pluginConfigurations) {
            if (configuration.types.contains(chartType)) {
                scripts.addAll(configuration.scripts);
            }
        }

        for (AAChartPluginScriptType script : scripts) {
            String scriptPath = generateScriptPath(script);
            if (scriptPath != null) {
                requiredPaths.add(scriptPath);
            }
        }
    }

    /**
     * Helper to add scripts based on specific AAOptions properties
     */
    private void addChartPluginScripts(AAOptions options, Set<String> requiredPaths) {
        // For polar charts, Highcharts-More is required
        if (options.chart != null && Boolean.TRUE.equals(options.chart.polar)) {
            String scriptPath = generateScriptPath(AAChartPluginScriptType.HIGHCHARTS_MORE);
            if (scriptPath != null) {
                requiredPaths.add(scriptPath);
            }
        }
        
        // For parallel coordinates charts
        if (options.chart != null && Boolean.TRUE.equals(options.chart.parallelCoordinates)) {
            String scriptPath = generateScriptPath(AAChartPluginScriptType.PARALLEL_COORDINATES);
            if (scriptPath != null) {
                requiredPaths.add(scriptPath);
            }
        }

        // For data module
        if (options.data != null) {
            String scriptPath = generateScriptPath(AAChartPluginScriptType.DATA);
            if (scriptPath != null) {
                requiredPaths.add(scriptPath);
            }
        }
    }

    /**
     * Generates the full path for a given script name
     */
    private String generateScriptPath(AAChartPluginScriptType script) {
        String scriptName = script.getRawValue();
        String fullScriptName = script.getFileName();
        String directoryPrefix = script.getDirectoryPrefix();
        
        // Plugin files are in {AAMaster|AAModules} directory
        String path = bundlePathLoader.path(scriptName, "js", directoryPrefix, null);
        
        if (path == null) {
            Log.w("AAChartView", "⚠️ Warning: Could not find path for script '" + fullScriptName + "'");
            return null;
        }
        
        return path;
    }
}

// MARK: - Bundle Path Loader Abstraction

/**
 * Protocol for loading bundle paths
 */
interface AAChartBundlePathLoadingProtocol {
    String path(String name, String type, String inDirectory, String forLocalization);
}

/**
 * Default implementation of bundle path loader
 */
class BundlePathLoader implements AAChartBundlePathLoadingProtocol {
    private final Context context;

    public BundlePathLoader(Context context) {
        this.context = context;
    }

    @Override
    public String path(String name, String type, String inDirectory, String forLocalization) {
        try {
            // Build the asset path
            String assetPath;
            if (inDirectory != null && !inDirectory.isEmpty()) {
                assetPath = inDirectory + "/" + name + "." + type;
            } else {
                assetPath = name + "." + type;
            }
            
            // Check if the file exists in assets
            InputStream inputStream = context.getAssets().open(assetPath);
            inputStream.close();
            
            // Return the asset path that can be used later
            return assetPath;
        } catch (Exception e) {
            return null;
        }
    }
}
