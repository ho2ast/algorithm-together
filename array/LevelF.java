package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> N개의 바구니와 공이 주어질 때 두 개의 바구니를 선택해 공을 교환 한 후 바구니에 들어 있는 공의 번호를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10813" />Baekjoon_10813 공 바꾸기</a>
 */
public class LevelF {
    /**
     * <p> 바구니 개수가 N, 교환 횟수가 M일 때 N 길이의 배열을 생성 해준 후 M만큼 loop를 돌며 교환 작업한다.
     * <p> 바구니를 배열, 공을 원소라 가정 한 후 원소는 인덱스+1 값을 넣어준다.
     * <p> 2번째 줄부터 교환할 바구니의 번호가 주어지므로 해당 인덱스의 값을 서로 교환한다.
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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int j = parseInt(st.nextToken()) - 1;
            int k = parseInt(st.nextToken()) - 1;
            int tmp = numArr[j];
            numArr[j] = numArr[k];
            numArr[k] = tmp;
        }
        br.close();

        for (int i = 0; i < N; i++) {
            sb.append(numArr[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
