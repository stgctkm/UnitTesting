package video.domain.price;

import org.junit.jupiter.api.Test;
import video.domain.movie.Movie;
import video.domain.movie.MovieType;
import video.domain.rental.Rental;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChildrenPriceTest {

    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", MovieType.CHILDREN);
    @Test
    void 子供用作品を4日のレンタル料金() {
        Rental sut = new Rental(子供用作品_となりのトトロ, 4);

        double result = sut.amount();

        assertEquals(300, result);
    }

    @Test
    void 子供用作品を3日のレンタル料金() {
        Rental sut = new Rental(子供用作品_となりのトトロ, 3);

        double result = sut.amount();

        assertEquals(150, result);
    }
}