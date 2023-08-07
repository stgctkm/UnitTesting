package video.domain.price;

public class RegularPrice implements Price {
    @Override
    public double charge(int daysRented) {
        double basicCharge = 2;
        if (daysRented > 2)
            return basicCharge + (daysRented - 2) * 1.5;
        return basicCharge;
    }
}
