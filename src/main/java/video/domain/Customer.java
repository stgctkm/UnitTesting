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
        int totalAmount = rentals.totalAmount();

        int frequentRenterPoints = rentals.totalFrequentRenterPoints();

        return new RentalResult(totalAmount, frequentRenterPoints);
    }

}