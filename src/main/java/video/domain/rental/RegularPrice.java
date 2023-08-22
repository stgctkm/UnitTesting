package video.domain.rental;

public class RegularPrice {
    public RegularPrice() {
    }

    int price(int daysRented) {
        if (daysRented <= 2) return 200;
        return 200 + (daysRented - 2) * 150;
    }
}