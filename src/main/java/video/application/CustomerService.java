package video.application;

import video.domain.Customer;
import video.domain.RentalResult;
import video.infrastructure.datasource.CustomerDataSource;
import video.infrastructure.datasource.RentalDataSource;
import video.infrastructure.transfer.RentalNotificationTransfer;

public class CustomerService {
    RentalDataSource rentalDataSource = new RentalDataSource();
    CustomerDataSource customerDataSource = new CustomerDataSource();
    RentalNotificationTransfer rentalNotificationTransfer = new RentalNotificationTransfer();
    public int rentalMovies(Customer customer) {

        RentalResult result = customer.rentalMovies();

        // レンタルの記録
        int rentalId = rentalDataSource.registerRental(customer.getName(), customer.getRentals(), result.totalAmount());

        // レンタルポイントの記録
        customerDataSource.registerRentalPoint(customer.getName(), result.frequentRenterPoints());

        // レンタルの通知
        rentalNotificationTransfer.notice(customer.getName(), customer.getRentals());

        return rentalId;
    }
}
