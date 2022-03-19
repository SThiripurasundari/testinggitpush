import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainClassTest {

    public static void main(String[] args) {
        double test = 12.56678789654;

        System.out.println("round :"+round(test,1));

        System.out.println("roundAvoid :"+round(test,1));

    }


    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();


    }


    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        System.out.print("scale" +scale);
        return Math.round(value * scale) / scale;
    }
}
