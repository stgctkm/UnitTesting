package video.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", PriceType.CHILDREN);
    Movie 旧作_トップガン = new Movie("トップガン", PriceType.REGULAR);
    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", PriceType.NEW_RELEASE);
    @Test
    void 新作を4日レンタル() {
        Customer sut = new Customer("鈴木一郎");
        sut.addRental(new Rental(新作_君たちはどう生きるか, 4));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(1200, result.totalAmount());
            assertEquals(2, result.frequentRenterPoints());
        });
    }

    @Test
    void 新作を1日レンタル() {
        Customer sut = new Customer("佐藤華子");
        sut.addRental(new Rental(新作_君たちはどう生きるか, 1));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(300, result.totalAmount());
            assertEquals(1, result.frequentRenterPoints());
        });
    }

    @Test
    void 旧作を2日レンタル() {
        Customer sut = new Customer("岡山圭太");
        sut.addRental(new Rental(旧作_トップガン, 2));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(200, result.totalAmount());
            assertEquals(1, result.frequentRenterPoints());
        });
    }

    @Test
    void 旧作を3日レンタル() {
        Customer sut = new Customer("香川真司");
        sut.addRental(new Rental(旧作_トップガン, 3));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(350, result.totalAmount());
            assertEquals(1, result.frequentRenterPoints());
        });
    }

    @Test
    void 子供用作品を4日レンタル() {
        Customer sut = new Customer("鈴木二郎");
        sut.addRental(new Rental(子供用作品_となりのトトロ, 4));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(300, result.totalAmount());
            assertEquals(1, result.frequentRenterPoints());
        });
    }

    @Test
    void 子供用作品を3日レンタル() {
        Customer sut = new Customer("広川京子");
        sut.addRental(new Rental(子供用作品_となりのトトロ, 3));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(150, result.totalAmount());
            assertEquals(1, result.frequentRenterPoints());
        });
    }

    @Test
    void 新作と旧作ビデオのレンタル() {
        Customer sut = new Customer("John Doe");
        sut.addRental(new Rental(旧作_トップガン, 7));
        sut.addRental(new Rental(新作_君たちはどう生きるか, 7));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(3050, result.totalAmount());
            assertEquals(3, result.frequentRenterPoints());
        });
    }

    @Test
    void 旧作と子供用作品のレンタル() {
        Customer sut = new Customer("Jane Doe");
        sut.addRental(new Rental(旧作_トップガン, 7));
        sut.addRental(new Rental(子供用作品_となりのトトロ, 7));

        RentalResult result = sut.rentalMovies();

        assertAll(() -> {
            assertEquals(1700, result.totalAmount());
            assertEquals(2, result.frequentRenterPoints());
        });
    }
}