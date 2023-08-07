package baekjoon.geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 세 변의 길이가 주어질 때 삼각형의 종류를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/5073"/>Baekjoon_5073 삼각형과 세 변</a></p>
 */
public class Level7 {
    /**
     * <p> 주어진 조건에 맞추어 삼각형의 종류를 출력한다.
     * <p> 여기서는 값을 비교하여 해결하였지만
     * <p> 중복된 값을 허용하지 않는 자료구조인 {@link java.util.Set}을 이용하여 해결할 수 있다.
     * <p> 각 원소들을 Set 으로 받아 Set의 길이를 확인하여 해결 할 수 있다.
     */
    public static void main(String[] args) throws IOException {
        Level7Triangle triangle;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while ((st = new StringTokenizer(br.readLine())) != null) {
            triangle = new Level7Triangle(parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()));
            String result = triangle.getTriangleTypes();
            if (result == null) {
                sb.deleteCharAt(sb.lastIndexOf("\n"));
                break;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}

class Level7Triangle {
    int first, second, third;

    public Level7Triangle(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getTriangleTypes() {
        if (isAllZero()) {
            return null;
        }

        if (isTriangle()) {
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
        return (sum - max) <= max;
    }

    public boolean isAllZero() {
        return this.first + this.second + this.third == 0;
    }
}
