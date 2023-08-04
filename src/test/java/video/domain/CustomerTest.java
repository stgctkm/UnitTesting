package video.domain;

import org.junit.jupiter.api.Test;
import video.infrastructure.datasource.CustomerDataSource;
import video.infrastructure.datasource.RentalDataSource;
import video.infrastructure.datasource.data.RentalSummary;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    CustomerDataSource customerDataSource = new CustomerDataSource();
    RentalDataSource rentalDataSource = new RentalDataSource();

    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", PriceType.CHILDREN);
    Movie 旧作_トップガン = new Movie("トップガン", PriceType.REGULAR);
    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", PriceType.NEW_RELEASE);
    @Test
    void 新作を4日レンタル() {
        Customer customer = new Customer("鈴木一郎");

        customer.addRental(new Rental(新作_君たちはどう生きるか, 4));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(12, rentalSummary.rentalRecord().totalAmount());

            assertEquals(2, customerDataSource.pointOf(customer.getName()));
        });
    }

    @Test
    void 新作を1日レンタル() {
        Customer customer = new Customer("佐藤華子");

        customer.addRental(new Rental(新作_君たちはどう生きるか, 1));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(3, rentalSummary.rentalRecord().totalAmount());

            assertEquals(1, customerDataSource.pointOf(customer.getName()));
        });
    }

    @Test
    void 旧作を2日レンタル() {
        Customer customer = new Customer("岡山圭太");

        customer.addRental(new Rental(旧作_トップガン, 2));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(2, rentalSummary.rentalRecord().totalAmount());

            assertEquals(1, customerDataSource.pointOf(customer.getName()));
        });
    }

    @Test
    void 旧作を3日レンタル() {
        Customer customer = new Customer("香川真司");

        customer.addRental(new Rental(旧作_トップガン, 3));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(3.5, rentalSummary.rentalRecord().totalAmount());

            assertEquals(1, customerDataSource.pointOf(customer.getName()));
        });
    }

    @Test
    void 子供用作品を4日レンタル() {
        Customer customer = new Customer("鈴木二郎");

        customer.addRental(new Rental(子供用作品_となりのトトロ, 4));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(3, rentalSummary.rentalRecord().totalAmount());

            assertEquals(1, customerDataSource.pointOf(customer.getName()));
        });
    }

    @Test
    void 子供用作品を3日レンタル() {
        Customer customer = new Customer("広末涼子");

        customer.addRental(new Rental(子供用作品_となりのトトロ, 3));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(1.5, rentalSummary.rentalRecord().totalAmount());

            assertEquals(1, customerDataSource.pointOf(customer.getName()));
        });
    }

    @Test
    void 新作と旧作ビデオのレンタル() {
        Customer customer = new Customer("John Doe");

        customer.addRental(new Rental(旧作_トップガン, 7));
        customer.addRental(new Rental(新作_君たちはどう生きるか, 7));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(30.5, rentalSummary.rentalRecord().totalAmount());
            assertEquals(2, rentalSummary.rentalItems().size());

            assertEquals(3, customerDataSource.pointOf(customer.getName()));
        });
    }

    @Test
    void 旧作と子供用作品のレンタル() {
        Customer customer = new Customer("Jane Doe");

        customer.addRental(new Rental(旧作_トップガン, 7));
        customer.addRental(new Rental(子供用作品_となりのトトロ, 7));

        int rentalId = customer.rentalMovies();

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(17.0, rentalSummary.rentalRecord().totalAmount());
            assertEquals(2, rentalSummary.rentalItems().size());

            assertEquals(2, customerDataSource.pointOf(customer.getName()));
        });
    }

}