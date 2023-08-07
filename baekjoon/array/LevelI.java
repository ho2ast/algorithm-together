package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> N개의 바구니가 주어지고, M번 바구니의 순서를 역순으로 바꾼 후 바구니의 번호를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10811" />Baekjoon_10811 바구니 뒤집기</a>
 */
public class LevelI {
    /**
     * <p> 길이가 N인 배열을 생성 후 1~N까지의 번호를 할당한다.</p>
     * <p> 그 후 주어진 범위의 바구니의 순서를 바꾸는 작업을 진행한다.</p>
     * <p> 주어진 범위로 loop를 역순으로 돌아 임시 배열에 값을 저장한 후 다시 원 배열에 역순의 값을 저장한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = i + 1;
        }

        for (int t= 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i = parseInt(st.nextToken());
            int j = parseInt(st.nextToken());

            if (i == j) {
                continue;
            }

            int[] tmpArr = new int[j - i + 1];
            for (int k = 0; k < j - i + 1; k++) {
                tmpArr[k] = numArr[j - 1 - k];
            }

            for (int k = 0; k < j - i + 1; k++) {
                numArr[i - 1 + k] = tmpArr[k];
            }
        }
        br.close();

        for (int num : numArr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
