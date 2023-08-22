package video.domain.price;

public class RegularPrice implements Price {
    public int amount(int daysRented) {
        if (daysRented <= 2) return 200;
        return 200 + (daysRented - 2) * 150;
    }
}