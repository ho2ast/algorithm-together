package baekjoon.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 주어진 알고리즘의 수행 횟수와, 최고차항의 차수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24263"/>Baekjoon_24263 알고리즘의 수행 시간 2</a>
 */
public class Level2 {
    /**
     * <p> 코드1은 주어진 n만큼 수행하게 된다. 따라서 시간복잡도는 O(N)으로 최고차항은 1이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(n);
        System.out.println(1);
    }
}
