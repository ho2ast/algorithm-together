package setandmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * <p> 수직선상의 좌표들이 주어질 때 이를 압축하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10815"/>Baekjoon_10815 숫자 카드</a>
 */
public class Level1 {
    /**
     * <p> {@link java.util.Map}을 이용하여 상근이가 가진 카드를 key로, 0을 value로 세팅한다.
     * <p> 그 후 주어지는 카드가 key로 존재할 경우 해당 value를 1로 업데이트 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<Integer, Integer> card = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            card.put(Integer.parseInt(st.nextToken()), 0);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            if (card.containsKey(key)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
