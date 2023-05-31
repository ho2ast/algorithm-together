package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> N장의 카드에 적힌 숫자가 주어 졌을 떄 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2798"/>Baekjoon_2798 블랙잭</a>
 */
public class Level1 {
    /**
     * <p> 주어진 N장의 카드를 정렬한다. 1 ~ n까지의 카드 중 최대값인 n부터 n-1, n-2 순으로 더해간다.
     * <p> 카드의 합이 주어진 M을 넘을 경우 인덱스를 1씩 줄여가며 계산한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(blackJack(N, M, numArr));
    }

    private static int blackJack(int N, int M, int[] numArr) {
        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            if (numArr[i] > M) continue;
            for (int j = i + 1; j < N - 1; j++) {
                if (numArr[i] + numArr[j] > M) continue;
                for (int k = j + 1; k < N; k++) {
                    int sum = numArr[i] + numArr[j] + numArr[k];
                    if (sum == M) {
                        return sum;
                    }

                    if (sum > result && sum < M) {
                        result = sum;
                    }
                }
            }
        }

        return result;
    }
}
