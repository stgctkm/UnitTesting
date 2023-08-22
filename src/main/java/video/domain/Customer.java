package video.domain;

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
        int totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental each : rentals.list()) {
            int thisAmount = each.amount();
            frequentRenterPoints += each.frequentRenterPoints();
            totalAmount += thisAmount;
        }

        return new RentalResult(totalAmount, frequentRenterPoints);
    }

}