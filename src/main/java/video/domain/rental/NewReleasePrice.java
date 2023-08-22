package video.domain.rental;

public class NewReleasePrice {
    public NewReleasePrice() {
    }

    int price(int daysRented) {
        return daysRented * 300;
    }
}