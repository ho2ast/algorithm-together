package geometry1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 주어진 좌표에서 직사각형의 경계선까지의 최소값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1085"/>Baekjoon_1085 직사각형에서 탈출</a>
 */
public class Level2 {
    /**
     * <p> 현재의 위치는 (x, y)이고 왼쪽 꼭짓점은 원점, 우측 위 꼭짓점은 (w, h) 일 경우
     * <p> x, w - x, y, h - y 중 최소값을 찾으면 경계선 까지의 최단거리가 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        br.close();

        int min = 0;
        min = Math.min(x, w - x);
        min = Math.min(min, y);
        min = Math.min(min, h - y);

        System.out.println(min);
    }
}
