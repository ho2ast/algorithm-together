package baekjoon.string;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 문자열 S를 입력받은 후, 각 문자를 R번 반복해서 새 문자열 P를 만든 후 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2675"/>Baekjoon_2675 문자열 반복</a></p>
 */
public class LevelG {
    /**
     * <p> 주어진 문자열의 길이 만큼 loop를 돌며 {@link String#charAt(int)}을 이용하여 각 자리의 문자를 구한다.</p>
     * <p> 그 후 {@link String#format(String, Object...)}을 이용하여 주어진 R만큼 빈칸과 해당 문자로 채운다. </p>
     * <p> 빈칸으로 채워진 문자열을 {@link String#replace(char, char)}을 이용하여 빈칸을 해당 문자로 변환한다. </p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String R = st.nextToken();
            String S = st.nextToken();
            for (int j = 0; j < S.length(); j++) {
                String charString = String.valueOf(S.charAt(j));
                String tempString = String.format("%" + R + "s", charString);
                tempString = tempString.replace(" ", charString);
                sb.append(tempString);
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
