package com.gnilkreb.fowler.test;

import com.gnilkreb.fowler.Customer;
import com.gnilkreb.fowler.Movie;
import com.gnilkreb.fowler.Rental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void testConstructorSavingName() {
        final Customer customer = new Customer("Marie");

        assertEquals(
                "Marie",
                customer.getName(),
                "The name of the customer has net been saved in the constructor."
        );
    }

    @Test
    public void testEmptyStatement() {
        final Customer customer = new Customer("Marie");

        assertEquals(
                "Rental Record for Marie\n" +
                        "\tTitle\t\tDays\tAmount\n" +
                        "Amount owed is 0.0\n" +
                        "You earned 0 frequent renter points",
                customer.statement(),
                "The output of an empty statement is wrong."
        );
    }

    @Test
    public void testSingleRentalRegularMovie() {
        final Customer customer = new Customer("Marie");
        final Rental rental = new Rental(
                new Movie("Hello World", Movie.PriceCode.Regular),
                3
        );
        customer.addRental(rental);

        assertEquals(
                "Rental Record for Marie\n" +
                        "\tTitle\t\tDays\tAmount\n" +
                        "\tHello World\t\t3\t3.5\n" +
                        "Amount owed is 3.5\n" +
                        "You earned 1 frequent renter points",
                customer.statement(),
                "There is a problem with the statement with a single regular movie rented."
        );
    }

    @Test
    public void testSingleRentalChildrenMovie() {
        final Customer customer = new Customer("Marie");
        final Rental rental = new Rental(
                new Movie("Hello World", Movie.PriceCode.Children),
                4
        );
        customer.addRental(rental);

        assertEquals(
                "Rental Record for Marie\n" +
                        "\tTitle\t\tDays\tAmount\n" +
                        "\tHello World\t\t4\t3.0\n" +
                        "Amount owed is 3.0\n" +
                        "You earned 1 frequent renter points",
                customer.statement(),
                "There is a problem with the statement with a single childrens movie rented."
        );
    }

    @Test
    public void testSingleRentalNewReleaseMovie() {
        final Customer customer = new Customer("Marie");
        final Rental rental = new Rental(
                new Movie("Hello World", Movie.PriceCode.NewRelease),
                3
        );
        customer.addRental(rental);

        assertEquals(
                "Rental Record for Marie\n" +
                        "\tTitle\t\tDays\tAmount\n" +
                        "\tHello World\t\t3\t9.0\n" +
                        "Amount owed is 9.0\n" +
                        "You earned 2 frequent renter points",
                customer.statement(),
                "There is a problem with the statement with a single new release movie rented."
        );
    }
}
