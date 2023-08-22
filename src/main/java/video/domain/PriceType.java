package video.domain;

import video.domain.price.ChildrenPrice;
import video.domain.price.NewReleasePrice;
import video.domain.price.RegularPrice;

public enum PriceType {
    CHILDREN,
    REGULAR,
    NEW_RELEASE;

    private final RegularPrice regularPrice = new RegularPrice();
    private final NewReleasePrice newReleasePrice = new NewReleasePrice();
    private final ChildrenPrice childrenPrice = new ChildrenPrice();

    int amount(int daysRented) {
        switch (this) {
            case REGULAR:
                return regularPrice.amount(daysRented);
            case NEW_RELEASE:
                return newReleasePrice.amount(daysRented);
            case CHILDREN:
                return childrenPrice.amount(daysRented);
            default:
                throw new RuntimeException("ビデオの区分が誤っています");
        }
    }
}
