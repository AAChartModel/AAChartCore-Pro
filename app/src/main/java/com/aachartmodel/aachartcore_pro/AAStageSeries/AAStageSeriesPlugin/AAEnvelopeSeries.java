package com.aachartmodel.aachartcore_pro.AAStageSeries.AAStageSeriesPlugin;

import com.aachartmodel.aacharts.aaoptionsmodel.AASeries;
import com.aachartmodel.aacharts.aaoptionsmodelpro.AAEnvelope;

public class AAEnvelopeSeries extends AASeries {
    //新增属性 envelope
    public AAEnvelope envelope;

    public AAEnvelopeSeries envelope(AAEnvelope prop) {
        envelope = prop;
        return this;
    }
}
