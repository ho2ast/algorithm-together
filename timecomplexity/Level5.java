package timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 주어진 알고리즘의 수행 횟수와, 최고차항의 차수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24266"/>Baekjoon_24266 알고리즘의 수행 시간 5</a>
 */
public class Level5 {
    /**
     * <p> 주어진 코드1은 삼중 loop 안에서 실행된다.
     * <p> 각 loop 는 n회 실행 되므로 코드1은 n<sup>3</sup>회 실행되며, O(N<sup>3</sup>)의 시간 복잡도를 가진다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(n * n * n);
        System.out.println(3);
    }
}
