package video.domain;

import video.domain.price.ChildrenPrice;
import video.domain.price.NewReleasePrice;
import video.domain.price.Price;
import video.domain.price.RegularPrice;

public enum PriceType {
    CHILDREN(new ChildrenPrice()),
    REGULAR(new RegularPrice()),
    NEW_RELEASE(new NewReleasePrice());

    Price price;

    PriceType(Price price) {
        this.price = price;
    }

    int amount(int daysRented) {
        return price.amount(daysRented);
    }
}
