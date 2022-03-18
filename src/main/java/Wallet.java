import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

public class Wallet {

    private final double faceValue;

    private Wallet(double faceValue, Currency currency) {
        this.faceValue = faceValue;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Double.compare(wallet.faceValue, faceValue) == 0 && currency == wallet.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(faceValue, currency);
    }

    private final Currency currency;


    public static Wallet rupees(double value) {
        return new Wallet(value,Currency.RUPEES);


    }
    public static Wallet dollar(double faceValue) {
        return new Wallet(faceValue,Currency.DOLLAR);


    }

    public Wallet putMoney(Wallet dollar2) {

        DecimalFormat df = new DecimalFormat("#.##");


        //convert to base dollar
        double temp1 = this.currency.convertToDollars(this.currency,this.faceValue);
        double temp2 = dollar2.currency.convertToDollars(dollar2.currency,dollar2.faceValue);

        System.out.println("Base in dollar   :"+temp1);
        System.out.println("Base in dollar    :"+temp2);

        //converted to appro currency
        temp1 = this.currency.convertToRequiredCurrecy(this.currency,temp1);
        temp2 = this.currency.convertToRequiredCurrecy(this.currency,temp2);


        System.out.println("temp1   : in desire currency :"+temp1);
        System.out.println("temp2   :in desired currency :"+temp2);

        System.out.println("temp 2convers   :"+df.format(temp1));

        System.out.println("temp 2convers    :"+df.format(temp2));

        double finalFaceValue = temp1+temp2;
        //change it to desired value

        finalFaceValue  =  Double.parseDouble(df.format(finalFaceValue ));


        System.out.println("TTTTTTT   :"+finalFaceValue);


        return new Wallet(finalFaceValue , this.currency);


    }

    @Override
    public String toString() {
        return "Wallet{" +
                "faceValue=" + faceValue +
                ", currency=" + currency +
                '}';
    }

    public Wallet take(Wallet that) throws Exception {

        //first convert to base dollar
        double inBaseAmountDollar = this.currency.convertToDollars(this.currency, this.faceValue);
        double inBaseAmountDollar2 = that.currency.convertToDollars(that.currency, that.faceValue);

        if (inBaseAmountDollar - inBaseAmountDollar2 < 0)
            {
                throw new Exception();
            }

            //then convert to needed currency
            double inNeedCurrencythis = this.currency.convertToRequiredCurrecy(this.currency, inBaseAmountDollar);
            double inNeedCurrencythat = this.currency.convertToRequiredCurrecy(this.currency, inBaseAmountDollar2);

            double finalData = inNeedCurrencythis - inNeedCurrencythat;

            System.out.println("FInal data after subtraction:" + finalData);

            return new Wallet(finalData, this.currency);
        }














/* private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();


    }


    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }*/

}
