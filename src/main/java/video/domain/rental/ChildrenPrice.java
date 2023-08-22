package video.domain.rental;

public class ChildrenPrice {
    public ChildrenPrice() {
    }

    int price(int daysRented) {
        if (daysRented <= 3) return 150;
        return 150 + (daysRented - 3) * 150;
    }
}