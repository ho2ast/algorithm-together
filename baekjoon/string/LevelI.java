package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 세자리 수 두개가 주어질 때 두 수를 역순으로 변환 후 큰 수를 출력하세요..</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2908"/>Baekjoon_2908 상수</a></p>
 */
public class LevelI {
    /**
     * <p> 세자리 수를 역순으로 구해야 한다. </p>
     * <p> 일의 자리 비교 후 큰 수만 역순으로 구해서 출력... 보다는 두 수를 역순으로 변환 후 비교하여 출력 </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String result = "";
        br.close();

        int A = parseInt(reverseString(st.nextToken()));
        int B = parseInt(reverseString(st.nextToken()));

        System.out.println(Math.max(A, B));
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }

    private static String reverseString(String arg) {
        StringBuilder sb = new StringBuilder();
        for (int i = arg.length() - 1; i > -1; i--) {
            sb.append(String.valueOf(arg.charAt(i)));
        }
        return sb.toString();
    }
}
