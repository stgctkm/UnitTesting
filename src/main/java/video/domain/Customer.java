package video.domain;

import video.domain.rental.Rental;
import video.domain.rental.Rentals;

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

    public Rentals getRentals() {
        return rentals;
    }

    public RentalResult rentalMovies() {
        int totalAmount = totalAmount();

        int frequentRenterPoints = 0;
        for (Rental each : rentals.list()) {
            frequentRenterPoints += each.frequentRenterPoints();
        }

        return new RentalResult(totalAmount, frequentRenterPoints);
    }

    private int totalAmount() {
        int totalAmount = 0;
        for (Rental each : rentals.list()) {
            int thisAmount = each.amount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

}