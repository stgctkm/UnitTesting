package video.domain.price;

public enum PriceType {
    CHILDREN(new ChildrenPrice()),
    REGULAR(new RegularPrice()),
    NEW_RELEASE(new NewReleasePrice());

    Price price;

    PriceType(Price price) {
        this.price = price;
    }

    public double charge(int daysRented) {
        return price.charge(daysRented);
    }
}
