package video.domain.rental;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import video.domain.Movie;
import video.domain.PriceType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalTest {

    Movie 子供用作品_となりのトトロ = new Movie("となりのトトロ", PriceType.CHILDREN);
    Movie 旧作_トップガン = new Movie("トップガン", PriceType.REGULAR);
    Movie 新作_君たちはどう生きるか = new Movie("君たちはどう生きるか", PriceType.NEW_RELEASE);

    @Nested
    class レンタル料金テスト {
        @Test
        void 新作を4日のレンタル料金() {
            Rental sut = new Rental(新作_君たちはどう生きるか, 4);

            double result = sut.amount();

            assertEquals(1200, result);
        }

    }

    @Nested
    class レンタルポイントテスト {
        @Test
        void 旧作のレンタルポイント() {
            Rental sut = new Rental(旧作_トップガン, 2);

            int result = sut.frequentRenterPoints();

            assertEquals(1, result);
        }
    }
}