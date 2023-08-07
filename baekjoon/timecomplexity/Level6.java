package baekjoon.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 주어진 알고리즘의 수행 횟수와, 최고차항의 차수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24267"/>Baekjoon_24267 알고리즘의 수행 시간 6</a>
 */
public class Level6 {
    /**
     * <p> 코드1은 삼중 loop 안에서 실행된다.
     * <p> 첫번째 loop는 n-1회 수행되고, 두번째 loop는 2 ~ n-1, 3 ~ n-1... n-2 ~ n-1, n-1, 세번째 loop는 3 ~ n, 4 ~ n .. n회 수행한다.
     * <p> n이 7일 때를 예로 들어보면.
     * <p> 첫번째는 5 4 3 2 1회, 2번째는 4 3 2 1회... 5번째는 1회 실행된다.
     * <p> 이는 n까지의 수 중 3가지를 중복없이 뽀아 수행하는 경우이다.
     * <p> 즉, nC3을 의미하고 이는 n!/(n-3)!*3!이다.
     * <p> 이는 (n-2)(n-1)n/6 이다.
     * <p> 식의 최대 차항은 3이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(((n - 2) * (n - 1) * n) / 6);
        System.out.println(3);
    }
}
