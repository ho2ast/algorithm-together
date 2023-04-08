package loop;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 입력받은 테이스케이스 개수인 정수 T가 주어지고 A, B가 주어 질 때, A+B를 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/15552" />Baekjoon_15552 빠른 A+B</a>
 */
public class LevelF {
    /**
     * <p> 빠른 입출력을 위해 {@link java.io.BufferedReader}와 {@link java.io.BufferedWriter}를 사용한다.
     * <p> {@link java.io.BufferedWriter}의 write()를 사용하여 출력 내용을 버퍼에 담은 후 flush()를 사용하여 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(A + B));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
