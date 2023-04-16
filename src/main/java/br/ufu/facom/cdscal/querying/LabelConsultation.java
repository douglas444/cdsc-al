package br.ufu.facom.cdscal.querying;

import br.ufu.facom.cdscal.Sample;

public class LabelConsultation {

    private final Integer label;
    private final Sample sample;

    public LabelConsultation(Integer label, Sample sample) {
        this.label = label;
        this.sample = sample;
    }

    public Integer getLabel() {
        return label;
    }

    public Sample getSample() {
        return sample;
    }
}
