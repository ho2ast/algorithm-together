package geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 옥구슬의 좌표가 주어질 떄 만들어 지는 직사각형의 넓이를 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/9063"/>Baekjoon_9063 대지</a>
 */
public class Level5 {
    /**
     * <p> 주어지는 각 좌표를 통해서 x, y의 최대값과 최소값을 구한다.
     * <p> 해당 최대값에서 최소값을 빼면 가로(maxX - minX), 세로(maxY - minY)의 길이가 나온다.
     * <p> 두 변을 곱해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        StringTokenizer st;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());

            minX = getMin(minX, x);
            minY = getMin(minY, y);
            maxX = getMax(maxX, x);
            maxY = getMax(maxY, y);
        }

        System.out.println((maxX - minX) * (maxY - minY));
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }

    private static int getMin(int min, int number) {
        return Math.min(min, number);
    }

    private static int getMax(int max, int number) {
        return Math.max(max, number);
    }
}
