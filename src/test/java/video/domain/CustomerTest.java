package video.domain;

import org.junit.jupiter.api.Test;
import video.domain.Customer;
import video.domain.Movie;
import video.domain.PriceType;
import video.domain.Rental;

class CustomerTest {

    @Test
    void statement() {
        Customer customer = new Customer("John Doe");

        customer.addRental(new Rental(new Movie("RRR", PriceType.REGULAR), 7));
        customer.addRental(new Rental(new Movie("君たちはどう生きるか", PriceType.NEW_RELEASE), 7));

        System.out.println(customer.statement());

    }
}