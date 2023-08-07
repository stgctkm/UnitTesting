package video.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public Rentals rentals() {
        return rentals;
    }

    public RentalResult rentalMovies() {
        double totalAmount = 0;
        for (Rental each : rentals.list()) {
            double thisAmount = each.charge();
            totalAmount += thisAmount;
        }
        int frequentRenterPoints = frequentRenterPoints();
        return new RentalResult(totalAmount, frequentRenterPoints);
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals.list()) {
            frequentRenterPoints += each.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}