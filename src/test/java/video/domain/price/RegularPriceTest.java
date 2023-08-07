package video.domain.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularPriceTest {

    @Test
    void 旧作を2日レンタルする料金() {
        RegularPrice sut = new RegularPrice();
        assertEquals(2, sut.charge(2));
    }

    @Test
    void 旧作を3日レンタルする料金() {
        RegularPrice sut = new RegularPrice();
        assertEquals(3.5, sut.charge(3));
    }
}