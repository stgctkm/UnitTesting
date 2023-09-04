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
}
