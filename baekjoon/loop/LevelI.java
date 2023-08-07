package baekjoon.loop;

import java.io.*;

/**
 * <p> 정수 N이 주어 질 때, 첫 줄에 별 하나 둘째 줄에 별 두개를 N번째 줄에 별 N개를 입력한다.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2438" />Baekjoon_2438 별 찍기 - 1</a>
 */
public class LevelI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                bw.write("*");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
