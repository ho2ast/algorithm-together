package baekjoon.geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 세 개의 막대기가 주어질 때 이를 이용해 만들 수 있는 삼각형의 최대 둘레를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/14215"/>Baekjoon_14215 세 막대</a>
 */
public class Level8 {
    /**
     * <p> 주어진 막대로 삼각형을 만들기 위해서는 우선 삼각형의 조건에 맞아야 한다.
     * <p> 삼각형은 가장 긴 변의 길이가 나머지 두 변의 합보다 작아야한다.
     * <p> 따라서 {@link Math#max} 함수를 이용하여 최대 길이의 막대를 구한다.
     * <p> 나머지 두 변의 합은 세 변의 길이의 합에 최대 값을 빼주면된다.
     * <p> 따라서 최대 길이의 변을 두변의 합보다 1이 작으면 되고 두변의 합과 더 해주면 최대 둘레가 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        Level8Triangle triangle = new Level8Triangle(parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken()));
        System.out.println(triangle.getMaxArea());
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}

class Level8Triangle {
    int first;
    int second;
    int third;

    public Level8Triangle(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getMaxArea() {
        int sum = Math.addExact(first, Math.addExact(second, third));
        int max = Math.max(first, Math.max(second, third));
        int sub = sum - max;

        if (sub > max) {
            return sum;
        }

        return sub + (sub - 1);
    }
}
