public enum Currency {
    RUPEES(74.85),
    DOLLAR(1);

    Currency(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    private final double currencyValue;


    public double convertToDollars(Currency currency, double faceValue) {
        System.out.println("In Wallet class current :"+currency);
        System.out.println("In Wallet class face value:"+faceValue);
        System.out.println("In Wallet class face value before :"+faceValue/currency.currencyValue);
        System.out.println("In Wallet class face value after "+roundAvoid(faceValue/currency.currencyValue,4));



        return  roundAvoid(faceValue/currency.currencyValue,4);
    }



    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public double convertToRequiredCurrecy(Currency currency, double faceValue)
    {
        System.out.println("Inside WalletTest "+ this.currencyValue);


        return roundAvoid(faceValue * this.currencyValue,4);


    }


}
