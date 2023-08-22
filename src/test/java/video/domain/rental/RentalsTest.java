package video.domain.rental;

import org.junit.jupiter.api.Test;
import video.domain.Movie;
import video.domain.PriceType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalsTest {
    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", PriceType.CHILDREN);
    Movie 旧作_トップガン = new Movie("トップガン", PriceType.REGULAR);
    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", PriceType.NEW_RELEASE);

    @Test
    void 合計金額の算出() {

        Rentals sut = new Rentals();
        sut.add(new Rental(旧作_トップガン, 7));
        sut.add(new Rental(子供用作品_となりのトトロ, 7));

        double totalAmount = sut.totalAmount();

        assertEquals(1700, totalAmount);

    }

    @Test
    void 合計レンタルポイントの算出() {
        Rentals sut = new Rentals();
        sut.add(new Rental(旧作_トップガン, 7));
        sut.add(new Rental(新作_君たちはどう生きるか, 7));

        int totalFrequentRenterPoints = sut.totalFrequentRenterPoints();

        assertEquals(3, totalFrequentRenterPoints);
    }
}