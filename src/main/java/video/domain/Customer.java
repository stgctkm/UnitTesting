package video.domain;

import video.domain.rental.Rental;
import video.domain.rental.RentalResult;
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

    public Rentals rentals() {
        return rentals;
    }

    public RentalResult rentalMovies() {
        return new RentalResult(rentals);
    }

}