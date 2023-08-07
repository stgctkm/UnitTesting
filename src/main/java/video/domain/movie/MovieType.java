package video.domain.movie;

import video.domain.price.ChildrenPrice;
import video.domain.price.NewReleasePrice;
import video.domain.price.Price;
import video.domain.price.RegularPrice;

public enum MovieType {
    CHILDREN(new ChildrenPrice()),
    REGULAR(new RegularPrice()),
    NEW_RELEASE(new NewReleasePrice());

    Price price;

    MovieType(Price price) {
        this.price = price;
    }

    public double charge(int daysRented) {
        return price.charge(daysRented);
    }
}
