package br.ufu.facom.cdscal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChunkBuilder {

    public final static long FIRST_TIMESTAMP = 0;

    private long timestamp;
    private List<Sample> samples;
    private final long chunkSize;

    public ChunkBuilder(final long chunkSize) {
        this.timestamp = FIRST_TIMESTAMP;
        this.chunkSize = chunkSize;
    }

    public Optional<Chunk> ingest(final Sample sample) {

        this.samples.add(sample);

        if (this.samples.size() >= this.chunkSize) {
            final Chunk chunk = new Chunk(this.timestamp, this.samples);
            this.samples = new ArrayList<>();
            this.timestamp++;
            return Optional.of(chunk);
        } else {
            return Optional.empty();
        }
    }


}
