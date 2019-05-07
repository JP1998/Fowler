package com.gnilkreb.fowler;

public class Movie {

    private String title;
    private PriceCode priceCode;

    public Movie(String newtitle, PriceCode newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCode arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public enum PriceCode {
        Children((days) -> {
            double thisAmount = 1.5;
            if (days > 3) {
                thisAmount += (days - 3) * 1.5;
            }
            return thisAmount;
        }),
        Regular((days) -> {
            double thisAmount = 2;
            if (days > 2) {
                thisAmount += (days - 2) * 1.5;
            }
            return thisAmount;
        }),
        NewRelease((days) -> days * 3);

        private AmountDetermination amountDetermination;

        PriceCode(AmountDetermination det) {
            this.amountDetermination = det;
        }

        public double getAmount(int daysRented) {
            return this.amountDetermination.determineAmount(daysRented);
        }
    }

    public interface AmountDetermination {
        double determineAmount(int days);
    }
}