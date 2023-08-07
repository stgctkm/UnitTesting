package video.domain.price;

public class NewReleasePrice implements Price {
    @Override
    public double charge(int daysRented) {
        return daysRented * 3;
    }
}
