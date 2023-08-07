package video.domain.rental;

import org.junit.jupiter.api.Test;
import video.domain.movie.Movie;
import video.domain.movie.MovieType;

import static org.junit.jupiter.api.Assertions.*;

class RentalsTest {

    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", MovieType.CHILDREN);
    Movie 旧作_トップガン = new Movie("トップガン", MovieType.REGULAR);
    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", MovieType.NEW_RELEASE);

    @Test
    void 新作と旧作と子供用ビデオのレンタルのポイント() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(子供用作品_となりのトトロ, 6));
        rentals.add(new Rental(旧作_トップガン, 7));
        rentals.add(new Rental(新作_君たちはどう生きるか, 7));

        double frequentRenterPoints = rentals.frequentRenterPoints();

        assertEquals(4, frequentRenterPoints);

    }

    @Test
    void 新作と旧作と子供用ビデオのレンタルの料金() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(子供用作品_となりのトトロ, 6));
        rentals.add(new Rental(旧作_トップガン, 7));
        rentals.add(new Rental(新作_君たちはどう生きるか, 7));

        double totalAmount = rentals.totalAmount();

        assertEquals(36.5, totalAmount);
    }
}