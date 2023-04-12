package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> N개의 바구니와 공이 주어질 때 규칙에 따라 공을 바구니에 넣은 후 바구니에 들어 있는 공의 번호를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10810" />Baekjoon_10810 공 넣기</a>
 */
public class LevelE {
    /**
     * <p> 바구니의 개수와 공 번호는 1부터 N까지 이므로 길이가 N인 배열을 생성한다.</p>
     * <p> 그 후 i~j번의 바구니에 k번 번호의 공을 넣기 때문에 배열의 해당 인덱스의 값을 k로 입력해준다.</p>
     * <p> 값이 있는 경우라도 새로 주어진 k값을 할당 해준다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N];

        for (int i = 0; i < M; i++) {
            int start, end, num;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;
            num = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                basket[j] = num;
            }
        }
        br.close();

        for (int num : basket) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
