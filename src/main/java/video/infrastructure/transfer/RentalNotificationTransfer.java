package video.infrastructure.transfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import video.domain.Rental;
import video.domain.Rentals;

public class RentalNotificationTransfer {

    private static final Logger logger = LoggerFactory.getLogger(RentalNotificationTransfer.class);
    public void notice(String customerName, Rentals rentals) {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals.list()) {
            result.append("Movie: " + rental.getMovie().getTitle() + " Days Rented: " + rental.getDaysRented() + " ");
        }
        logger.info(customerName + ": " + result);
    }
}
