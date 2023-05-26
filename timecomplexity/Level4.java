package timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 주어진 알고리즘의 수행 횟수와, 최고차항의 차수를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/24265"/>Baekjoon_24265 알고리즘의 수행 시간 4</a>
 */
public class Level4 {
    /**
     * <p> 코드1은 이중 for 문 안에서 의해 실행된다.
     * <p> 첫번째 for 문에서 1부터 n-1번 실행되고,
     * <p> 첫번째 loop 의 각 실행마다 두번째 for 문이 n-1, n-2, ..., 1번 실행된다.
     * <p> 따라서 코드1의 실행 횟수는 1부터 n-1까지 의 합인 n * (n-1) / 2번  즉, n<sup>2</sup>-n / 2회 실행된다.
     * <p> 시간복잡도는 최고차항으로 표현 하므로 O(n<sup>2</sup>)이며 최고차항은 2이다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(((n * n) - n) / 2);
        System.out.println(2);
    }
}
