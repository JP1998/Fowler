package com.gnilkreb.fowler.test;

import com.gnilkreb.fowler.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieTest {

    @Test
    public void testConstructorNameStored() {
        final Movie movie = new Movie("Some Name", Movie.REGULAR);

        assertEquals(
                "Some Name",
                movie.getTitle(),
                "The supplied name of the movie has not been stored."
        );
    }

    @Test
    public void testConstructorPriceCodeStored() {
        final Movie movie = new Movie("Some Name", Movie.CHILDRENS);

        assertEquals(
                Movie.CHILDRENS,
                movie.getPriceCode(),
                "The supplied price code of the movie has not been stored."
        );
    }

    @Test
    public void testSetterPriceCodeStored() {
        final Movie movie = new Movie("Some Name", Movie.CHILDRENS);

        movie.setPriceCode(Movie.NEW_RELEASE);

        assertEquals(
                Movie.NEW_RELEASE,
                movie.getPriceCode(),
                "The supplied price code of the movie has not been stored."
        );
    }

    @Test
    public void testConstructorCheckPriceCodeValidity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Movie("Some Name", -1),
                "The given price code has not been checked for validity."
        );
    }

    @Test
    public void testSetterCheckPriceCodeValidity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    final Movie movie = new Movie("Some Name", Movie.REGULAR);
                    movie.setPriceCode(-1);
                },
                "The given price code has not been checked for validity."
        );
    }

}
