package baekjoon.generalmath;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> B진법 수 N이 주어질 때, 이 수를 10진법으로 바꾸어 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2745"/>Baekjoon_2745 진법 변환</a></p>
 */
public class LevelA {
    /**
     * <p> B진법이라 하면 B를 밑으로 한다.</p>
     * <p> 예를 들어 36진법이고 ZZ가 주어진 경우 Z는 35이다.</p>
     * <p> 따라서 35 * 36<sup>1</sup> + 35 * 36<sup>0</sup> 로 표현 할 수 있다.</p>
     * <p> 아스키코드에서 A는 65이므로 10이 되려면 55를 빼주면 된다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int decimalNumber = 0;
        br.close();

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N.length(); i++) {
            int character = N.charAt(i);

            if (character >= 65) {
                character -= 55;
            } else {
                character -= 48;
            }

            int operand = (int) Math.pow(B, N.length() - 1 - i);
            decimalNumber += character * operand;
        }

        System.out.println(decimalNumber);
    }
}
