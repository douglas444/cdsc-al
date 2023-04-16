package br.ufu.facom.cdscal;

import java.util.Collections;
import java.util.List;

public class Cluster {

    private final Sample center;
    private final double radius;
    private final double density;
    private final List<MicroSummary> microSummaries;

    public Cluster(final Sample center,
                   final double radius,
                   final double density,
                   final List<MicroSummary> microSummaries) {
        this.center = center;
        this.radius = radius;
        this.density = density;
        this.microSummaries = Collections.unmodifiableList(microSummaries);
    }

    public Sample getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getDensity() {
        return density;
    }

    public List<MicroSummary> getMicroSummaries() {
        return microSummaries;
    }

}
