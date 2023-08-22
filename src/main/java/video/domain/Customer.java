package video.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public RentalResult rentalMovies() {
        int totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            int thisAmount = each.amount();
            frequentRenterPoints += frequentRenterPoints(each);
            totalAmount += thisAmount;
        }

        return new RentalResult(totalAmount, frequentRenterPoints);
    }

    private int frequentRenterPoints(Rental each) {
        // 新作を二日以上借りた場合はボーナスポイント
        if ((each.getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
            each.getDaysRented() > 1) return 2;
        return 1;
    }

}