package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/10807" />Baekjoon_10807 개수 세기</a>
 */
public class LevelA {
    /**
     * <p>첫째 줄에는 정수의 개수 N, 둘째 줄에는 정수가 공백으로 구분, 셋째 줄에는 찾으려고 하는 정수 v가 주어진다.</p>
     * <p>둘째 줄의 정수를 {@link StringTokenizer}로 잘라 반복문을 사용하여 배열을 생성한다.</p>
     * <p>그 후 배열에서 찾고자 하는 v의 개수를 구한 후 리턴.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : numArr) {
            if (num == v) {
                result++;
            }
        }

        System.out.println(result);
    }
}
