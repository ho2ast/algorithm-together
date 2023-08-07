package baekjoon.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 시간 H와 M을 입력 받아 45분 앞서는 시간을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2884" />Baekjoon_2884 알람 시계</a>
 */
public class LevelE {
    /**
     * <p> newM = m-45, newM < 0 일 경우 newM + 60, newH = h-1
     * <p> newH < 0 일 경우 newH + 24를 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int newH = h;
        int newM = m - 45;

        if (newM < 0) {
            newH--;
            if (newH < 0) {
                newH += 24;
            }
            newM += 60;
        }
        sb.append(newH).append(" ").append(newM);

        System.out.println(sb);
    }
}
