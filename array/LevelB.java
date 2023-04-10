package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10871" />Baekjoon_10871 X보다 작은 수</a>
 */
public class LevelB {
    /**
     * <p> 첫 줄에 N과 X가 주어진다.
     * <p> 둘째 줄에는 수열 A를 이루는 정수 N개가 주어진다.</p>
     * <p> 정수 N만큼 loop를 실행하며 배열을 만든 후 X와 비교하여 작은 수를 {@link StringBuilder}에 담아 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        br.close();

        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : numArr) {
            if (num < X) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}
