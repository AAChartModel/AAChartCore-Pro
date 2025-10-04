package com.aachartmodel.aachartcore_pro.AAStageSeries.AAStageSeriesPlugin;

import com.aachartmodel.aacharts.aaoptionsmodelpro.AAEnvelope;

/**
 * AASeriesEnvelopeExtension - AASeries的Envelope扩展帮助类
 * 
 * 由于Java不支持像Swift那样的Extension特性,
 * 这个类提供了静态方法来帮助设置Series的envelope属性
 * 
 * 使用方法:
 * Map<String, Object> seriesOptions = new HashMap<>();
 * AASeriesEnvelopeExtension.setEnvelope(seriesOptions, envelope);
 */
public class AASeriesEnvelopeExtension {
    
    /**
     * 将AAEnvelope对象添加到Series选项Map中
     * 
     * @param seriesOptions Series选项Map
     * @param envelope AAEnvelope对象
     */
    public static void setEnvelope(java.util.Map<String, Object> seriesOptions, AAEnvelope envelope) {
        if (seriesOptions != null && envelope != null) {
            seriesOptions.put("envelope", envelope);
        }
    }
    
    /**
     * 从Series选项Map中获取AAEnvelope对象
     * 
     * @param seriesOptions Series选项Map
     * @return AAEnvelope对象,如果不存在则返回null
     */
    public static AAEnvelope getEnvelope(java.util.Map<String, Object> seriesOptions) {
        if (seriesOptions != null && seriesOptions.containsKey("envelope")) {
            Object envelope = seriesOptions.get("envelope");
            if (envelope instanceof AAEnvelope) {
                return (AAEnvelope) envelope;
            }
        }
        return null;
    }
}
