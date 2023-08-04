package video.domain;

import video.infrastructure.datasource.CustomerDataSource;
import video.infrastructure.datasource.RentalDataSource;
import video.infrastructure.transfer.RentalNotificationTransfer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    RentalDataSource rentalDataSource = new RentalDataSource();
    CustomerDataSource customerDataSource = new CustomerDataSource();
    RentalNotificationTransfer rentalNotificationTransfer = new RentalNotificationTransfer();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public int rentalMovies() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            double thisAmount = 0;
            // 一行ごとに金額を計算
            switch (each.getMovie().getPriceType()) {
                case REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
            // レンタルポイントを加算
            frequentRenterPoints++;
            // 新作を二日以上借りた場合はボーナスポイント
            if ((each.getMovie().getPriceType() == PriceType.NEW_RELEASE) &&
                each.getDaysRented() > 1) frequentRenterPoints++;
            totalAmount += thisAmount;
        }

        // レンタルの記録
        int rentalId = rentalDataSource.registerRental(name, rentals, totalAmount);

        // レンタルポイントの記録
        customerDataSource.registerRentalPoint(name, frequentRenterPoints);

        // レンタルの通知
        rentalNotificationTransfer.notice(name, rentals);

        return rentalId;
    }
}