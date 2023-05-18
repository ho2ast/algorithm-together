package geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * <p> 세점이 주어졌을 때 축에 평행한 직사각형을 만들기 위한 네번째 점을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/3009"/>Baekjoon_3009 네 번째 점</a>
 */
public class Level3 {
    /**
     * <p> 직사각형은 각 축 마다 같은 점이 2개씩 나와야 한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = parseInt(st.nextToken());
        int y1 = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = parseInt(st.nextToken());
        int y2 = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = parseInt(st.nextToken());
        int y3 = parseInt(st.nextToken());
        br.close();

        if (x1 == x2) {
            sb.append(x3);
        } else {
            if (x2 == x3) {
                sb.append(x1);
            } else {
                sb.append(x2);
            }
        }
        sb.append(" ");
        if (y1 == y2) {
            sb.append(y3);
        } else {
            if (y2 == y3) {
                sb.append(y1);
            } else {
                sb.append(y2);
            }
        }

        System.out.print(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
