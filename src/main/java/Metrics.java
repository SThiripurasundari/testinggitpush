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

/*
public enum Metrics {
    KILOMETER(100000),
    METER(100),
    CENTIMETER(1);

    private final double conversionFactor;

    Metrics(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double convertToThisMetric(double magnitude, Metrics metrics) {
        return magnitude * metrics.conversionFactor/ conversionFactor;
    }

    public double convertToBaseMetric(double magnitude) {
        return magnitude * conversionFactor;
    }
}

 */
