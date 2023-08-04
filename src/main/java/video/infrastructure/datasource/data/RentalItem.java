package video.infrastructure.datasource.data;

import video.domain.Movie;

public record RentalItem(Movie movie, int days) {
}
