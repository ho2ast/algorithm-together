package baekjoon.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 주어진 알고리즘의 수행 횟수와, 최고차항의 차수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24264"/>Baekjoon_24264 알고리즘의 수행 시간 3</a>
 */
public class Level3 {
    /**
     * <p> 코드1은 이중 for문에 의해 실행된다.
     * <p> 첫번째 for문 n번, 두번째 for문 n번 실행된다.
     * <p> 따라서 코드1의 실행 횟수는 n<sup>2</sup>회 실행된다.
     * <p> 시간복잡도는 O(n<sup>2</sup>)이며 최고차항은 2이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(n * n);
        System.out.println(2);
    }
}
