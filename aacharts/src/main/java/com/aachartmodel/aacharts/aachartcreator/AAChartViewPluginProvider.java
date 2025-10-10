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
 * ◉◉◉       // Helper to add scripts based on chart type string
    private void addChartPluginScripts(String chartType, Set<String> requiredPaths) {
        if (chartType == null) {
            return;
        }

        Set<String> scripts = new HashSet<>();
        for (AAChartPluginConfiguration configuration : pluginConfigurations) {
            if (configuration.types.contains(chartType)) {
                scripts.addAll(configuration.scripts);
            }
        }

        for (String script : scripts) {
            String scriptPath = generateScriptPath(script);
            if (scriptPath != null) {
                requiredPaths.add(scriptPath);
            }
        }
    }AChartModel/AAChartCore-Kotlin     ◉◉◉
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// MARK: - Shared Plugin Script Definition

/**
 * Interface representing all available plugin scripts
 */
interface AAChartPluginScriptType {
    // AAInfographics normal version plugins
    String HIGHCHARTS_MORE = "AAHighcharts-More";
    String FUNNEL = "AAFunnel";
    
    // AAInfographics pro version plugins
    String SANKEY = "AASankey";
    String DEPENDENCY_WHEEL = "AADependency-Wheel";
    String NETWORKGRAPH = "AANetworkgraph";
    String ORGANIZATION = "AAOrganization";
    String ARC_DIAGRAM = "AAArc-Diagram";
    String VENN = "AAVenn";
    String TREEMAP = "AATreemap";
    String SUNBURST = "AASunburst";
    String FLAME = "AAFlame";
    String VARIABLE_PIE = "AAVariable-Pie";
    String VARIWIDE = "AAVariwide";
    String DUMBBELL = "AADumbbell";
    String LOLLIPOP = "AALollipop";
    String HISTOGRAM_BELLCURVE = "AAHistogram-Bellcurve";
    String BULLET = "AABullet";
    String HEATMAP = "AAHeatmap";
    String TILEMAP = "AATilemap";
    String STREAMGRAPH = "AAStreamgraph";
    String XRANGE = "AAXrange";
    String TIMELINE = "AATimeline";
    String SOLID_GAUGE = "AASolid-Gauge";
    String VECTOR = "AAVector";
    String ITEM_SERIES = "AAItem-Series";
    String WINDBARB = "AAWindbarb";
    String WORDCLOUD = "AAWordcloud";
    String TREEGRAPH = "AATreegraph";
    String PICTORIAL = "AAPictorial";
    String PARALLEL_COORDINATES = "AAParallel-Coordinates";
    String DATA = "AAData";
    String DATA_GROUPING = "AADatagrouping";
}

/**
 * Helper class for plugin script metadata
 */
class AAPluginScriptHelper {
    private static final Map<String, String> DIRECTORY_MAP = new HashMap<>();
    
    static {
        // AAMaster directory plugins (standard version)
        DIRECTORY_MAP.put(AAChartPluginScriptType.HIGHCHARTS_MORE, "AAMaster");
        DIRECTORY_MAP.put(AAChartPluginScriptType.FUNNEL, "AAMaster");
        
        // AAModules directory plugins (pro version)
        DIRECTORY_MAP.put(AAChartPluginScriptType.SANKEY, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.DEPENDENCY_WHEEL, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.NETWORKGRAPH, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.ORGANIZATION, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.ARC_DIAGRAM, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.VENN, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.TREEMAP, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.SUNBURST, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.FLAME, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.VARIABLE_PIE, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.VARIWIDE, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.DUMBBELL, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.LOLLIPOP, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.HISTOGRAM_BELLCURVE, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.BULLET, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.HEATMAP, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.TILEMAP, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.STREAMGRAPH, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.XRANGE, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.TIMELINE, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.SOLID_GAUGE, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.VECTOR, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.ITEM_SERIES, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.WINDBARB, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.WORDCLOUD, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.TREEGRAPH, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.PICTORIAL, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.PARALLEL_COORDINATES, "AAModules");
        DIRECTORY_MAP.put(AAChartPluginScriptType.DATA, "AAModules");
    DIRECTORY_MAP.put(AAChartPluginScriptType.DATA_GROUPING, "AAModules");
    }
    
    /**
     * Returns the complete JavaScript file name with .js extension
     */
    public static String getFileName(String pluginScript) {
        return pluginScript + ".js";
    }
    
    /**
     * Returns the directory prefix for the plugin script
     * Highcharts-More and Funnel are in AAMaster, others are in AAModules
     */
    public static String getDirectoryPrefix(String pluginScript) {
        return DIRECTORY_MAP.getOrDefault(pluginScript, "AAModules");
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
        final List<String> scripts;

        AAChartPluginConfiguration(String[] types, String[] scripts) {
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
            new String[] { AAChartPluginScriptType.HIGHCHARTS_MORE }
        ),
        
        // --- Funnel & Pyramid Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Funnel, AAChartType.Pyramid },
            new String[] { AAChartPluginScriptType.FUNNEL }
        ),
        
        // --- Flow & Relationship Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Sankey },
            new String[] { AAChartPluginScriptType.SANKEY }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Dependencywheel },
            new String[] { AAChartPluginScriptType.SANKEY, AAChartPluginScriptType.DEPENDENCY_WHEEL }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Networkgraph },
            new String[] { AAChartPluginScriptType.NETWORKGRAPH }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Organization },
            new String[] { AAChartPluginScriptType.SANKEY, AAChartPluginScriptType.ORGANIZATION }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Arcdiagram },
            new String[] { AAChartPluginScriptType.SANKEY, AAChartPluginScriptType.ARC_DIAGRAM }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Venn },
            new String[] { AAChartPluginScriptType.VENN }
        ),

        // --- Hierarchical Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Treemap },
            new String[] { AAChartPluginScriptType.TREEMAP }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Sunburst },
            new String[] { AAChartPluginScriptType.HIGHCHARTS_MORE, AAChartPluginScriptType.SUNBURST }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Flame },
            new String[] { AAChartPluginScriptType.HIGHCHARTS_MORE, AAChartPluginScriptType.FLAME }
        ),

        // --- Distribution & Comparison Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Variablepie },
            new String[] { AAChartPluginScriptType.VARIABLE_PIE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Variwide },
            new String[] { AAChartPluginScriptType.VARIWIDE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Dumbbell },
            new String[] { AAChartPluginScriptType.HIGHCHARTS_MORE, AAChartPluginScriptType.DUMBBELL }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Lollipop },
            new String[] { AAChartPluginScriptType.HIGHCHARTS_MORE, AAChartPluginScriptType.DUMBBELL, AAChartPluginScriptType.LOLLIPOP }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Histogram },
            new String[] { AAChartPluginScriptType.HISTOGRAM_BELLCURVE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Bellcurve },
            new String[] { AAChartPluginScriptType.HISTOGRAM_BELLCURVE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Bullet },
            new String[] { AAChartPluginScriptType.BULLET }
        ),

        // --- Heatmap & Matrix Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Heatmap },
            new String[] { AAChartPluginScriptType.HEATMAP }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Tilemap },
            new String[] { AAChartPluginScriptType.HEATMAP, AAChartPluginScriptType.TILEMAP }
        ),

        // --- Time, Range & Stream Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Streamgraph },
            new String[] { AAChartPluginScriptType.STREAMGRAPH }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Xrange },
            new String[] { AAChartPluginScriptType.XRANGE }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Timeline },
            new String[] { AAChartPluginScriptType.TIMELINE }
        ),

        // --- Gauge & Indicator Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Solidgauge },
            new String[] { AAChartPluginScriptType.HIGHCHARTS_MORE, AAChartPluginScriptType.SOLID_GAUGE }
        ),

        // --- Specialized & Other Charts ---
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Vector },
            new String[] { AAChartPluginScriptType.VECTOR }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Item },
            new String[] { AAChartPluginScriptType.ITEM_SERIES }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Windbarb },
            new String[] { AAChartPluginScriptType.DATA_GROUPING, AAChartPluginScriptType.WINDBARB }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Wordcloud },
            new String[] { AAChartPluginScriptType.WORDCLOUD }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Treegraph },
            new String[] { AAChartPluginScriptType.TREEMAP, AAChartPluginScriptType.TREEGRAPH }
        ),
        new AAChartPluginConfiguration(
            new String[] { AAChartType.Pictorial },
            new String[] { AAChartPluginScriptType.PICTORIAL }
        )
    );

    @Override
    public Set<String> getRequiredPluginPaths(AAOptions options) {
    Set<String> requiredPaths = new LinkedHashSet<>();

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

    Set<String> scripts = new LinkedHashSet<>();
        for (AAChartPluginConfiguration configuration : pluginConfigurations) {
            if (configuration.types.contains(chartType)) {
                scripts.addAll(configuration.scripts);
            }
        }

        for (String script : scripts) {
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
    private String generateScriptPath(String script) {
        String scriptName = script;
        String fullScriptName = AAPluginScriptHelper.getFileName(script);
        String directoryPrefix = AAPluginScriptHelper.getDirectoryPrefix(script);
        
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
