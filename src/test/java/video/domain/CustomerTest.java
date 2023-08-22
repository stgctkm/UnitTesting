package video.domain;

import org.junit.jupiter.api.Test;
import video.domain.rental.Rental;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", MovieType.CHILDREN);
    Movie 旧作_トップガン = new Movie("トップガン", MovieType.REGULAR);
    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", MovieType.NEW_RELEASE);

    @Test
    void 新作と旧作と子供用作品のレンタル() {
        Customer sut = new Customer("John Doe");
        sut.addRental(new Rental(旧作_トップガン, 7));
        sut.addRental(new Rental(新作_君たちはどう生きるか, 7));
        sut.addRental(new Rental(子供用作品_となりのトトロ, 7));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(3800, result.totalAmount());
            assertEquals(4, result.frequentRenterPoints());
        });
    }
}