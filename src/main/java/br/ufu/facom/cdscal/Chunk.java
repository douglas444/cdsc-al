package br.ufu.facom.cdscal;

import java.util.Collections;
import java.util.List;

public class Chunk {

    private final long timestamp;
    private final List<Sample> samples;

    public Chunk(final long timestamp, final List<Sample> samples) {
        this.timestamp = timestamp;
        this.samples = Collections.unmodifiableList(samples);
    }

    public long getTimestamp() {
        return timestamp;
    }

    public List<Sample> getSamples() {
        return samples;
    }

}
