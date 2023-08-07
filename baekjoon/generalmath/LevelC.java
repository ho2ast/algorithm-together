package baekjoon.generalmath;

import java.io.*;

/**
 * <p> 돌려주어야 할 거스름 돈의 개수를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2720"/>Baekjoon_2720 세탁소 사장 동혁</a></p>
 */
public class LevelC {
    /**
     * <p> 주어야 할 거스름돈이 센트단위로 주어지므로 거스름돈의 단위를 센트로 변환하여 나눈다.</p>
     * <p> 가장 큰 단위의 거스름돈으로 액수를 나눈다.</p>
     * <p> 거스름돈으로 나눈 몫이 주어야 할 해당 단위의 개수이고 나머지가 남은 거스름돈 액수이다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            bw.write(calculateChange(Integer.parseInt(br.readLine())));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static String calculateChange(int change) {
        StringBuilder sb = new StringBuilder();
        int[] changeUnit = {25, 10, 5, 1};
        int index = 0;
        for (int i = 0; i < 4; i++) {
            sb.append(change / changeUnit[index]).append(" ");
            change = change % changeUnit[index];
            index++;
        }

        return String.valueOf(sb);
    }
}
