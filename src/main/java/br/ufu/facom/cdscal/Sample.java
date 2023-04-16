package br.ufu.facom.cdscal;

public class Sample {

    private final double[] x;
    private final Integer y;

    public Sample(final double[] x, final Integer y) {
        this.x = x;
        this.y = y;
    }

    public double[] getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

}
