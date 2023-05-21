package geometry1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Level6Test {
    @Test
    void kindTriangles() {
        TriangleTest triangle = new TriangleTest(50, 50, 80);
        System.out.println(triangle.kindTriangle());
    }
}

class TriangleTest {
    int first;
    int second;
    int third;

    public TriangleTest(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String kindTriangle() {
        if (sumAngle()) {
            return "Error";
        }

        if (this.first == this.second && this.second == this.third) {
            return "Equilateral";
        } else if (this.first == this.second || this.first == this.third || this.second == this.third) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public boolean sumAngle() {
        return this.first + this.second + this.third != 180;
    }
}