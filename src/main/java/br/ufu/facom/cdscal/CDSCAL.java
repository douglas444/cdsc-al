package br.ufu.facom.cdscal;

import br.ufu.facom.cdscal.merging.ClusterMergingAlgorithm;
import br.ufu.facom.cdscal.querying.ActiveQueryingAlgorithm;
import br.ufu.facom.cdscal.querying.LabelConsultation;
import br.ufu.facom.cdscal.clustering.ClusteringAlgorithm;
import br.ufu.facom.cdscal.ranking.RankingAlgorithm;

import java.util.ArrayList;
import java.util.List;


public class CDSCAL {

    private final ClusteringAlgorithm clusteringAlgorithm;
    private final RankingAlgorithm rankingAlgorithm;
    private final ActiveQueryingAlgorithm activeQueryingAlgorithm;
    private final ClusterMergingAlgorithm clusterMergingAlgorithm;

    private final ChunkBuilder chunkBuilder;
    private final MacroSummary macroSummary;

    public CDSCAL(final ClusteringAlgorithm clusteringAlgorithm,
                  final RankingAlgorithm rankingAlgorithm,
                  final ActiveQueryingAlgorithm activeQueryingAlgorithm,
                  final ClusterMergingAlgorithm clusterMergingAlgorithm,
                  final long chunkSize) {

        this.clusteringAlgorithm = clusteringAlgorithm;
        this.rankingAlgorithm = rankingAlgorithm;
        this.activeQueryingAlgorithm = activeQueryingAlgorithm;
        this.clusterMergingAlgorithm = clusterMergingAlgorithm;

        this.chunkBuilder = new ChunkBuilder(chunkSize);
        this.macroSummary = new MacroSummary();
    }

    public List<Classification> process(final Sample sample) {

        final List<Classification> classifications = new ArrayList<>();

        this.chunkBuilder.ingest(sample).ifPresent(chunk -> {

            final List<Sample> rankedSamples = this.rankingAlgorithm.execute(chunk.getSamples());
            List<Cluster> clusters = this.clusteringAlgorithm.execute(rankedSamples);

            if (chunk.getTimestamp() > ChunkBuilder.FIRST_TIMESTAMP) {
                clusters = this.clusterMergingAlgorithm.execute(clusters, this.macroSummary.getClusters());
            }

            final List<LabelConsultation> labelConsultations = this.activeQueryingAlgorithm.execute(clusters);
            classifications.addAll(this.classify(rankedSamples, clusters, labelConsultations));
            this.macroSummary.update(clusters, chunk);


        });

        return classifications;

    }

    private List<Classification> classify(final List<Sample> rankedSamples,
                                          final List<Cluster> clusters,
                                          final List<LabelConsultation> labelConsultations) {

        return new ArrayList<>();

    }

}
