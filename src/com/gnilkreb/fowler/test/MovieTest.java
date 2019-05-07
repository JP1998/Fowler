package com.gnilkreb.fowler.test;

import com.gnilkreb.fowler.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void testConstructorNameStored() {
        final Movie movie = new Movie("Some Name", Movie.PriceCode.Regular);

        assertEquals(
                "Some Name",
                movie.getTitle(),
                "The supplied name of the movie has not been stored."
        );
    }

    @Test
    public void testConstructorPriceCodeStored() {
        final Movie movie = new Movie("Some Name", Movie.PriceCode.Children);

        assertEquals(
                Movie.PriceCode.Children,
                movie.getPriceCode(),
                "The supplied price code of the movie has not been stored."
        );
    }

    @Test
    public void testSetterPriceCodeStored() {
        final Movie movie = new Movie("Some Name", Movie.PriceCode.Children);

        movie.setPriceCode(Movie.PriceCode.NewRelease);

        assertEquals(
                Movie.PriceCode.NewRelease,
                movie.getPriceCode(),
                "The supplied price code of the movie has not been stored."
        );
    }
}
