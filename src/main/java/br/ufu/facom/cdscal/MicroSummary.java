package br.ufu.facom.cdscal;

public class MicroSummary {

    private final Sample center;
    private final Integer label;

    public MicroSummary(final Sample center, final Integer label) {
        this.center = center;
        this.label = label;
    }

    public Sample getCenter() {
        return center;
    }

    public Integer getLabel() {
        return label;
    }
}
