package video.domain.rental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    List<Rental> list = new ArrayList<>();

    public List<Rental> list() {
        return list;
    }

    public void add(Rental rental) {
        list.add(rental);
    }

    int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : list()) {
            frequentRenterPoints += each.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    double totalAmount() {
        double totalAmount = 0;
        for (Rental each : list()) {
            double thisAmount = each.charge();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }
}
