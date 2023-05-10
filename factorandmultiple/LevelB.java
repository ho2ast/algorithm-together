package factorandmultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2501"/>Baekjoon_2501 약수 구하기</a></p>
 */
public class LevelB {
    /**
     * <p> N이 주어질 때 1부터 N까지 loop를 돌며 나머지가 0인 약수를 구한다. </p>
     * <p> 약수일 때 1씩 추가되는 인덱스를 사용하여 해당 인덱스가 K와 일치할 때 출력한다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        br.close();

        int index = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                index++;
            }

            if (index == K) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
