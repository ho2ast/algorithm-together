package baekjoon.geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 세 각이 주어질 때 삼각형의 종류를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10101"/>Baekjoon_10101 삼각형 외우기</a></p>
 */
public class Level6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = parseInt(br.readLine());
        int second = parseInt(br.readLine());
        int third = parseInt(br.readLine());

        System.out.println(new Triangle(first, second, third).kindTriangle());
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}

class Triangle {
    int first;
    int second;
    int third;

    public Triangle(int first, int second, int third) {
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