package baekjoon.loop;

import java.io.*;

/**
 * <p> 정수 N이 주어 질 때, 첫 줄에 별 하나 둘째 줄에 별 두개를 N번째 줄에 별 N개를 입력한다.
 * <p> 우측으로 정렬하여 출력한다.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2439" />Baekjoon_2439 별 찍기 - 2</a>
 */
public class LevelJ {
    /**
     * <p> 이중 loop를 사용하여 띄어쓰기와 별을 입력하도록 한다.
     * <p> 우측으로 정렬하여 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        int N = Integer.parseInt(br.readLine()) + 1;

        for (int i = 1; i < N; i++) {
            sb = new StringBuilder();
            for (int j = N - 1; j > i; j--) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
