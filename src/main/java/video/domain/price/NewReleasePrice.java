package video.domain.price;

public class NewReleasePrice implements Price {

    public int amount(int daysRented) {
        return daysRented * 300;
    }
}