package video.domain.price;

import org.junit.jupiter.api.Test;
import video.domain.Movie;
import video.domain.MovieType;
import video.domain.rental.Rental;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewReleasePriceTest {

    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", MovieType.NEW_RELEASE);

    @Test
    void 新作を4日のレンタル料金() {
        Rental sut = new Rental(新作_君たちはどう生きるか, 4);

        double result = sut.amount();

        assertEquals(1200, result);
    }
}