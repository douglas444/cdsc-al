package br.ufu.facom.cdscal;

import java.util.ArrayList;
import java.util.List;

public class MacroSummary {

    private List<Cluster> clusters;

    public MacroSummary() {
        this.clusters = new ArrayList<>();
    }

    public void update(List<Cluster> clusters, Chunk chunk) {
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

}
