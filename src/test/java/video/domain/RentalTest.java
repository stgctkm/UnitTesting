package video.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import video.domain.rental.Rental;

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


        @Test
        void 旧作を2日のレンタル料金() {
            Rental sut = new Rental(旧作_トップガン, 2);

            double result = sut.amount();

            assertEquals(200, result);
        }

        @Test
        void 旧作を3日のレンタル料金() {
            Rental sut = new Rental(旧作_トップガン, 3);

            double result = sut.amount();

            assertEquals(350, result);
        }

        @Test
        void 子供用作品を4日のレンタル料金() {
            Rental sut = new Rental(子供用作品_となりのトトロ, 4);

            double result = sut.amount();

            assertEquals(300, result);
        }

        @Test
        void 子供用作品を3日のレンタル料金() {
            Rental sut = new Rental(子供用作品_となりのトトロ, 3);

            double result = sut.amount();

            assertEquals(150, result);
        }
    }

    @Nested
    class レンタルポイントテスト {
        @Test
        void 新作を4日のレンタルポイント() {
            Rental sut = new Rental(新作_君たちはどう生きるか, 4);

            int result = sut.frequentRenterPoints();

            assertEquals(2, result);
        }

        @Test
        void 新作を1日のレンタルポイント() {
            Rental sut = new Rental(新作_君たちはどう生きるか, 1);

            int result = sut.frequentRenterPoints();

            assertEquals(1, result);
        }

        @Test
        void 旧作のレンタルポイント() {
            Rental sut = new Rental(旧作_トップガン, 2);

            int result = sut.frequentRenterPoints();

            assertEquals(1, result);
        }

        @Test
        void 子供用作品のレンタル料金() {
            Rental sut = new Rental(子供用作品_となりのトトロ, 3);

            int result = sut.frequentRenterPoints();

            assertEquals(1, result);
        }
    }

}