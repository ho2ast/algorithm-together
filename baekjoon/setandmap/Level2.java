package baekjoon.setandmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * <p> 문자열이 주어질 때 몇 개가 집합에 포함되어 있는지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/14425"/>Baekjoon_14425 문자열 집합</a>
 */
public class Level2 {
    /**
     * <p> N개의 문자열을 {@link Set}에 저장한 후 M개의 문자열을 받은 후
     * <p> {@link Set#contains(Object)}함 수를 이용하여 있는 경우에는 결과값에 +1을 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) {
                result++;
            }
        }

        System.out.println(result);
    }
}
