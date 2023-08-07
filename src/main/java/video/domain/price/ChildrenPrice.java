package video.domain.price;

public class ChildrenPrice implements Price {


    @Override
    public double charge(int daysRented) {
        double basicCharge = 1.5;
        if (daysRented > 3) {
            return basicCharge + (daysRented - 3) * 1.5;
        }
        return basicCharge;
    }
}
