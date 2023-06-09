package geometry1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Level7Test {
    @Test
    void getKindOfTriangle() {
        Level7TestTriangle triangle = new Level7TestTriangle(6, 5, 4);
        Level7TestTriangle triangle2 = new Level7TestTriangle(2, 2, 2);
        Level7TestTriangle triangle3 = new Level7TestTriangle(6, 2, 6);
        Level7TestTriangle triangle4 = new Level7TestTriangle(3, 2, 5);
        Level7TestTriangle triangle5 = new Level7TestTriangle(0, 0, 0);

        Assertions.assertThat(triangle.getTriangleTypes()).isEqualTo("Scalene");
        Assertions.assertThat(triangle2.getTriangleTypes()).isEqualTo("Equilateral");
        Assertions.assertThat(triangle3.getTriangleTypes()).isEqualTo("Isosceles");
        Assertions.assertThat(triangle4.getTriangleTypes()).isEqualTo("Invalid");
        Assertions.assertThat(triangle5.getTriangleTypes()).isEqualTo(null);
    }
}

class Level7TestTriangle {
    int first, second, third;

    public Level7TestTriangle(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getTriangleTypes() {
        if (isAllZero()) {
            return null;
        }

        if (!isTriangle()) {
            return "Invalid";
        }

        if (this.first == this.second && this.second == this.third) {
            return "Equilateral";
        } else if (this.first == this.second || this.second == this.third || this.first == this.third) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public boolean isTriangle() {
        int max;
        int sum = this.first + this.second + this.third;
        max = Math.max(this.first, Math.max(this.second, this.third));
        return (sum - max) > max;
    }

    public boolean isAllZero() {
        return this.first + this.second + this.third == 0;
    }
}

