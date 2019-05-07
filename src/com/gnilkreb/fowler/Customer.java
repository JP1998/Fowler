package com.gnilkreb.fowler;

import java.lang.*;
import java.util.*;

public class Customer {

    private String name;
    private List<Rental> rentals;

    public Customer(String newname) {
        name = newname;
        rentals = new Vector<>();
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        StringBuilder result = new StringBuilder("Rental Record for ");
        result.append(this.getName());
        result.append("\n\tTitle\t\tDays\tAmount\n");

        for(Rental each : rentals) {
            double thisAmount = 0;
            //determine amounts for each line
            thisAmount = amountFor(each);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMoviePriceCode() == Movie.PriceCode.NewRelease) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            //show figures for this rental
            result.append("\t");
            result.append(each.getMovie().getTitle());
            result.append("\t\t");
            result.append(each.getDaysRented());
            result.append("\t");
            result.append(thisAmount);
            result.append("\n");

            totalAmount += thisAmount;
        }

        //add footer lines
        result.append("Amount owed is ");
        result.append(totalAmount);
        result.append("\nYou earned ");
        result.append(frequentRenterPoints);
        result.append(" frequent renter points");

        return result.toString();
    }

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMoviePriceCode()) {
            case Regular:
                thisAmount += 2;
                if (each.getDaysRented() > 2)
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                break;
            case NewRelease:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Children:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3)
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
    