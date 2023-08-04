package video.infrastructure.datasource.data;

import java.util.List;

public record RentalSummary(RentalRecord rentalRecord, List<RentalItem> rentalItems) {
}
