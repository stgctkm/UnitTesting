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
            int thisAmount = 0;
            // 一行ごとに金額を計算
            switch (each.getMovie().getPriceType()) {
                case REGULAR:
                    thisAmount += 200;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 150;
                    break;
                case NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 300;
                    break;
                case CHILDREN:
                    thisAmount += 150;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 150;
                    break;
            }
            // レンタルポイントを加算
            frequentRenterPoints++;
            // 新作を二日以上借りた場合はボーナスポイント
            if ((each.getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
                each.getDaysRented() > 1) frequentRenterPoints++;
            totalAmount += thisAmount;
        }

        return new RentalResult(totalAmount, frequentRenterPoints);
    }
}