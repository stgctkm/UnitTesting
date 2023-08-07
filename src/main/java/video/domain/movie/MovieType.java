package video.domain.movie;

import video.domain.point.ChildrenPoint;
import video.domain.point.NewReleasePoint;
import video.domain.point.Point;
import video.domain.point.RegularPoint;
import video.domain.price.ChildrenPrice;
import video.domain.price.NewReleasePrice;
import video.domain.price.Price;
import video.domain.price.RegularPrice;

public enum MovieType {
    CHILDREN(new ChildrenPrice(), new ChildrenPoint()),
    REGULAR(new RegularPrice(), new RegularPoint()),
    NEW_RELEASE(new NewReleasePrice(), new NewReleasePoint());

    final Price price;
    final Point point;

    MovieType(Price price, Point point) {
        this.price = price;
        this.point = point;
    }

    public double charge(int daysRented) {
        return price.charge(daysRented);
    }

    public int frequentRenterPoints(int daysRented) {
        return point.frequentRenterPoints(daysRented);
    }
}