package com.gnilkreb.fowler.test;

import com.gnilkreb.fowler.Movie;
import com.gnilkreb.fowler.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {

    @Test
    public void testMovieStored() {
        final Movie movie = new Movie("8 Mile", Movie.REGULAR);
        final Rental rent = new Rental(movie, 12);

        assertEquals(movie, rent.getMovie(), "The supplied movie has not been stored.");
    }

    @Test
    public void testDaysRentedStored() {
        final Movie movie = new Movie("8 Mile", Movie.REGULAR);
        final Rental rent = new Rental(movie, 12);

        assertEquals(12, rent.getDaysRented(), "The days of rental have not been stored.");
    }
}
