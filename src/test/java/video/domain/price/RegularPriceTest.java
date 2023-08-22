package video.domain.price;

import org.junit.jupiter.api.Test;
import video.domain.movie.Movie;
import video.domain.movie.MovieType;
import video.domain.rental.Rental;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegularPriceTest {

    Movie 旧作_トップガン = new Movie("トップガン", MovieType.REGULAR);

    @Test
    void 旧作を2日のレンタル料金() {
        Rental sut = new Rental(旧作_トップガン, 2);

        double result = sut.amount();

        assertEquals(200, result);
    }

    @Test
    void 旧作を3日のレンタル料金() {
        Rental sut = new Rental(旧作_トップガン, 3);

        double result = sut.amount();

        assertEquals(350, result);
    }
}