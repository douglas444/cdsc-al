package br.ufu.facom.cdscal.clustering;

import br.ufu.facom.cdscal.Cluster;
import br.ufu.facom.cdscal.Sample;

import java.util.List;

public interface ClusteringAlgorithm {

    List<Cluster> execute(final List<Sample> samples);

}
