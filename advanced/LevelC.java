package advanced;

import java.io.*;

/**
 * <p> 정수 N이 주어 질 때 규칙에 맞게 별을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2444"/>Baekjoon_2444 별 찍기 - 7</a></p>
 */
public class LevelC {
    /**
     * <p> 주어진 2*N-1줄 까지 홀수개의 별을 찍는다.</p>
     * <p> 공백은 N-1부터 0까지 그 후 1개부터 N-1까지 생성된다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < N; i++) {
            int oddNum = i * 2 + 1;
            for (int j = N - 1 - i; j > 0; j--) {
                bw.write(" ");
            }
            for (int j = 0; j < oddNum; j++) {
                bw.write("*");
            }
            bw.newLine();
        }

        for (int i = N - 1; i > 0; i--) {
            int oddNum = i * 2 - 1;
            for (int j = 0; j < N - i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < oddNum; j++) {
                bw.write("*");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
