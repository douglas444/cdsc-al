package br.ufu.facom.cdscal.merging;

import br.ufu.facom.cdscal.Cluster;

import java.util.List;

public interface ClusterMergingAlgorithm {

    List<Cluster> execute(List<Cluster> clusters1, List<Cluster> clusters2);

}
