package video.domain.point;

public class ChildrenPoint implements Point {
    @Override
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
