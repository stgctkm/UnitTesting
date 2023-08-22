package video.domain.rental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    List<Rental> list = new ArrayList<>();

    public void add(Rental rental) {
        list.add(rental);
    }

    public List<Rental> list() {
        return list;
    }

    public int totalAmount() {
        int totalAmount = 0;
        for (Rental each : list()) {
            int thisAmount = each.amount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    public int totalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : list()) {
            frequentRenterPoints += each.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}
