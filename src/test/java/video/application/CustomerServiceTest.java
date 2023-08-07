package video.application;

import org.junit.jupiter.api.Test;
import video.domain.*;
import video.domain.movie.Movie;
import video.domain.movie.MovieType;
import video.infrastructure.datasource.CustomerDataSource;
import video.infrastructure.datasource.RentalDataSource;
import video.infrastructure.datasource.data.RentalSummary;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {
    CustomerDataSource customerDataSource = new CustomerDataSource();
    RentalDataSource rentalDataSource = new RentalDataSource();

    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", MovieType.CHILDREN);
    Movie 旧作_トップガン = new Movie("トップガン", MovieType.REGULAR);
    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", MovieType.NEW_RELEASE);

    @Test
    void 新作と旧作ビデオのレンタル() {
        Customer customer = new Customer("John Doe");
        customer.addRental(new Rental(旧作_トップガン, 7));
        customer.addRental(new Rental(新作_君たちはどう生きるか, 7));

        CustomerService sut = new CustomerService();

        int rentalId = sut.rentalMovies(customer);

        RentalSummary rentalSummary = rentalDataSource.rentalRecordOf(rentalId);
        assertAll(() -> {
            assertEquals(30.5, rentalSummary.rentalRecord().totalAmount());
            assertEquals(2, rentalSummary.rentalItems().size());

            assertEquals(3, customerDataSource.pointOf(customer.getName()));
        });
    }
}
