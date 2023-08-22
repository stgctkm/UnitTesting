package video.domain.point;

public class RegularPoint implements Point {
    @Override
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
}
