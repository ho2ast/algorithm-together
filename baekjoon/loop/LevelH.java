package baekjoon.loop;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 두 정수 A,B를 입력 받은 후, 출력 형식에 맞추어 A+B를 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/11022" />Baekjoon_11022 A+B - 8</a>
 */
public class LevelH {
    /**
     * <p>{@link BufferedReader}를 이용해 입력 받은 후 {@link BufferedWriter}를 이용하여 출력한다.</p>
     * <p>{@link BufferedReader}와 {@link BufferedWriter}를 사용 후 꼭 close()를 한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i + 1).append(": ").append(A + " + " + B).append(" = ").append(A + B);
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
