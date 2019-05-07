package com.gnilkreb.fowler.test;

import com.gnilkreb.fowler.Movie;
import com.gnilkreb.fowler.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testNoMovieRentedCheck() {
        assertThrows(
                IllegalArgumentException.class,
                () -> { new Rental(null, 1); },
                "There is no check for a rented movie being null."
        );
    }

    @Test
    public void testInvalidDaysRentedCheck() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    final Movie rentedMovie = new Movie("asdf", Movie.REGULAR);
                    new Rental(rentedMovie, -1);
                },
                "The days rented are not being checked for validity."
        );
    }
}
