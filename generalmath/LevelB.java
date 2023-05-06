package generalmath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 10진법 수 N이 주어질 때, 이 수를 B진법으로 바꾸어 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11005"/>Baekjoon_11005 진법 변환2</a></p>
 */
public class LevelB {
    /**
     * <p> 10진수 수 N을 B진법으로 변환하기 위해서는 몫이 B보다 작아 질 떄 까지 N을 B로 나누어 나머지를 거꾸로 구한다.</p>
     * <p> 이후 나머지를 아스키코드에 맞춰 문자로 변환한다. 이때 값이 10보다 크거나 같을 경우 55를 더해 알파벳으로 변환한다.</p>
     * <p> 또한 나머지를 역순으로 읽어야 하나, loop에서 인덱스는 처음부터 진행하므로 {@link StringBuilder#insert(int, char)}를 활용하여</p>
     * <p> 가장 앞자리에 B진법 값을 채울 수 있도록 한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (N >= B) {
            int remainder = N % B;

            sb.insert(0, Character.toChars(addForAscii(remainder)));
            N = N / B;
        }
        sb.insert(0, Character.toChars(addForAscii(N)));

        System.out.println(sb);
    }

    private static int addForAscii(int number) {
        if (number >= 10) {
            number += 55;
        } else {
            number += 48;
        }

        return number;
    }
}
