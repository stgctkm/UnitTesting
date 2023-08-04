package video.infrastructure.transfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import video.domain.Rental;

import java.util.List;

public class RentalNotificationTransfer {

    private static final Logger logger = LoggerFactory.getLogger(RentalNotificationTransfer.class);
    public void notice(String customerName, List<Rental> rentals, String result) {
        logger.info(result);
    }
}
