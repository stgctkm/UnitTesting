package video.domain.rental;

public record RentalResult(
        Rentals rentals
) {
    public int frequentRenterPoints() {
        return rentals.frequentRenterPoints();
    }

    public double totalAmount() {
        return rentals.totalAmount();
    }
}
