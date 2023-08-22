package video.domain.point;

public class NewReleasePoint implements Point {
    @Override
    public int frequentRenterPoints(int daysRented) {
        // 新作を二日以上借りた場合はボーナスポイント
        if (daysRented > 1) return 2;
        return 1;
    }
}
