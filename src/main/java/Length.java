import java.util.Objects;

public class Length {

    private double value;
    private Metrics metrics;

    private Length(double value, Metrics metrics) {
        this.value = value;
        this.metrics = metrics;
    }

    public static Length centimeter(double value) {
        return new Length(value, Metrics.CENTIMETER);
    }

    public static Length meter(double value) {
        return new Length(value, Metrics.METER);
    }

    public static Length kilometer(double value) {
        return new Length(value, Metrics.KILOMETER);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length that = (Length) o;
        return Double.compare(this.metrics.getInCM(this.value, this.metrics),
                that.metrics.getInCM(that.value, that.metrics)) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, metrics);
    }

    public Length add(Length input) {
        /*Length cm = Length.centimeter(1000);
        Length m = Length.meter(10);

        Length output = Length.centimeter(2000);

        assertThat(output, is(cm.add(m)));*/
        double convertedtoThisParameter;
        // first convert cm to base cm
        double baseCM = input.metrics.getInCM(input.value, input.metrics);
        double baseCM2 = this.metrics.getInCM(input.value, input.metrics);
        System.out.println("STPE 1 :base in CM :" + baseCM + " Base 2 : " + baseCM2);
        //then cm to m

        convertedtoThisParameter = this.metrics.getConvertedValue(baseCM);
        System.out.println("Step 2: convertedtoThisParameter:" + baseCM);

        double temp = this.value + convertedtoThisParameter;
        System.out.println("Step 3: temp:" + temp);
        return new Length(temp, this.metrics);


    }

    public Length subtract(Length inputObject) {
        // convert to base
        double basedata = this.metrics.getInCM(inputObject.value, inputObject.metrics);
        System.out.println("STPE 1 :base in CM :" + basedata);

        //convert in required format
        double requiredFormat = this.metrics.getConvertedValue(basedata);
        System.out.println("Step 2: convertedtoThisParameter:" + requiredFormat);

        // minus now
        double afterminus = this.value - requiredFormat;
        System.out.println("Step 3: temp:" + afterminus);
        return new Length(afterminus, this.metrics);
    }
}

/*public class Length {

    private final double magnitude;
    private final Metrics metrics;

    private Length(double magnitude, Metrics metrics) {
        this.magnitude = magnitude;
        this.metrics = metrics;
    }

    public static Length centimeter(double magnitude) {
        return new Length(magnitude, Metrics.CENTIMETER);
    }

    public static Length meter(double magnitude) {
        return new Length(magnitude, Metrics.METER);
    }

    public static Length kilometer(double magnitude) {
        return new Length(magnitude, Metrics.KILOMETER);
    }

    public Length add(Length length) {
        double magnitudeToAdd = metrics.convertToThisMetric(length.magnitude, length.metrics);

        double resultantLength = magnitude + magnitudeToAdd;

        return new Length(resultantLength, metrics);
    }

    public Length minus(Length length) {

        double magnitudeToMinus = metrics.convertToThisMetric(length.magnitude, length.metrics);

        double resultantLength = magnitude - magnitudeToMinus;

        return new Length(resultantLength, metrics);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        Length that = (Length) obj;
        return metrics.convertToBaseMetric(magnitude) == that.metrics.convertToBaseMetric(that.magnitude);
    }

}
*/