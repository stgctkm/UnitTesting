package video.infrastructure.datasource.data;

import video.domain.movie.Movie;

public record RentalItem(Movie movie, int days) {
}
