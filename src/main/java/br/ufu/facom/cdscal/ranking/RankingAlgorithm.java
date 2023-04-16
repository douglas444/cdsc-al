package br.ufu.facom.cdscal.ranking;

import br.ufu.facom.cdscal.Sample;

import java.util.List;

public interface RankingAlgorithm {

    List<Sample> execute(final List<Sample> samples);

}
