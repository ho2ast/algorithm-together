package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * <p> 좌표가 N개 주어질 떄 y 오름차순으로, y가 같을 경우 x오름 차순으로 정렬 후 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11651"/>Baekjoon_11651 좌표 정렬하기 2</a>
 */
public class Level8 {
    /**
     * <p> 좌표의 객체를 만들어 {@link Comparable} 구현하거나 또는 {@link java.util.Comparator} 만들어
     * <p> {@link Arrays#sort(int[])}를 이용하여 정렬한다.
     * <p> {@link Comparable} 와 {@link java.util.Comparator} y값이 같을 경우에는 x값 비교를 하도록 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // Comparable 구현
//        Point[] arr = new Point[N];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//
//        Arrays.sort(arr);
//
//        for (Point p : arr) {
//            sb.append(p.x).append(" ").append(p.y).append("\n");
//        }

        // Comparator 사용
        Point[] arr2 = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr2[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr2, (p1, p2) -> {
            if (p1.y == p2.y) {
                return p1.x - p2.x;
            }
            return p1.y - p2.y;
        });

        for (Point p : arr2) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.println(sb);
    }

    static class Point implements Comparable {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point point = (Point) o;
            if (this.y == point.y) {
                return this.x - point.x;
            }
            return this.y - point.y;
        }
    }

}
