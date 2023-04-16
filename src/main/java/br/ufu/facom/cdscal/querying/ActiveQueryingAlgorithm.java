package br.ufu.facom.cdscal.querying;

import br.ufu.facom.cdscal.Cluster;

import java.util.List;

public interface ActiveQueryingAlgorithm {

    List<LabelConsultation> execute(final List<Cluster> clusters);

}
