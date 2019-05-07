package com.gnilkreb.fowler;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public Movie.PriceCode getMoviePriceCode() {
        return movie.getPriceCode();
    }

    public double getAmount() {
        return movie.getPriceCode().getAmount(this.daysRented);
    }
}