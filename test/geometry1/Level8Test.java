package geometry1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Level8Test {
    @Test
    void getMaxArea() {
        Level8Triangle triangle = new Level8Triangle(41, 64, 16);

        Assertions.assertThat(triangle.getMaxArea()).isEqualTo(113);
    }
}

class Level8TriangleTest {
    int first;
    int second;
    int third;

    public Level8TriangleTest(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getMaxArea() {
        int sum = Math.addExact(first, Math.addExact(second, third));
        int max = Math.max(first, Math.max(second, third));
        int sub = sum - max;

        return sub + (sub - 1);
    }
}
