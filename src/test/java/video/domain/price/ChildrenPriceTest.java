package video.domain.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChildrenPriceTest {

    @Test
    void 子供作品を3日レンタルする料金() {
        ChildrenPrice sut = new ChildrenPrice();
        assertEquals(1.5, sut.charge(3));
    }

    @Test
    void 子供作品を4日レンタルする料金() {
        ChildrenPrice sut = new ChildrenPrice();
        assertEquals(3, sut.charge(4));
    }
}