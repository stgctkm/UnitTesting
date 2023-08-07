package video.domain.point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewReleasePointTest {
    @Test
    void 新作を1日レンタルする料金() {
        NewReleasePoint sut = new NewReleasePoint();
        assertEquals(1, sut.frequentRenterPoints(1));
    }

    @Test
    void 新作を2日レンタルする料金() {
        NewReleasePoint sut = new NewReleasePoint();
        assertEquals(2, sut.frequentRenterPoints(2));
    }
}