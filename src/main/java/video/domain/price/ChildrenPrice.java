package video.domain.price;

public class ChildrenPrice implements Price {
    public int amount(int daysRented) {
        if (daysRented <= 3) return 150;
        return 150 + (daysRented - 3) * 150;
    }
}