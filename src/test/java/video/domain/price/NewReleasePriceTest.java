package video.domain.price;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewReleasePriceTest {


    @Test
    void 新作を2日レンタルする料金() {
        NewReleasePrice sut = new NewReleasePrice();
        assertEquals(6, sut.charge(2));
    }
}