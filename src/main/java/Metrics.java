public enum Metrics {
    CENTIMETER (1),
    METER(100),
    KILOMETER(100000);

    Metrics(double conversion) {
        this.conversion = conversion;
    }

    private final double conversion;

    public double getInCM(double value, Metrics metrics)
    {
            return value * metrics.conversion;
    }

    public double getConvertedValue(double value)
    {
        return value/this.conversion;

    }

}
