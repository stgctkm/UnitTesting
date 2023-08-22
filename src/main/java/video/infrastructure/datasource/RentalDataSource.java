package video.infrastructure.datasource;

import video.domain.Rental;
import video.domain.Rentals;
import video.infrastructure.datasource.data.RentalItem;
import video.infrastructure.datasource.data.RentalRecord;
import video.infrastructure.datasource.data.RentalSummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RentalDataSource {

    static Map<Integer, RentalRecord> rentalRecords = new HashMap<>();

    static Map<Integer, List<RentalItem>> rentalItems = new HashMap<>();

    AtomicInteger rentalNumber = new AtomicInteger(0);

    /**
     * レンタルの記録
     */
    public int registerRental(String customerName, Rentals rentals, int totalAmount) {

        int rentalId = rentalNumber.incrementAndGet();
        rentalRecords.put(rentalId, new RentalRecord(customerName, totalAmount));
        ArrayList<RentalItem> items = new ArrayList<>();
        for (Rental rental : rentals.list()) {
            items.add(new RentalItem(rental.getMovie(), rental.getDaysRented()));
        }
        rentalItems.put(rentalId, items);
        return rentalId;
    }

    public RentalSummary rentalRecordOf(int rentalId) {
        RentalRecord rentalRecord = rentalRecords.get(rentalId);
        List<RentalItem> items = rentalItems.get(rentalId);
        return new RentalSummary(rentalRecord, items);
    }

}
