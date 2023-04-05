package condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 시간 H와 M을 입력 받고 오븐 가동시간 C가 주어 졌을 때 종료되는 시간을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2525" />Baekjoon_2525 오븐 시계</a>
 */
public class LevelF {
    /**
     * <p> 주어진 H를 분으로 변환 후 계산 해준다. 변환 후 다시 60으로 나누어 시간을 계산 만약 H/60 > 23 일 경우 -24를 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        br.close();

        int hToM = H * 60;

        int totalM = hToM + M + C;

        int newH = totalM / 60;
        int newM = totalM % 60;

        if (newH > 23) {
            newH -= 24;
        }

        sb.append(newH).append(" ").append(newM);

        System.out.println(sb);
    }
}
