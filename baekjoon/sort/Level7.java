package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * <p> 좌표가 N개 주어질 떄 x 오름차순으로, x가 같을 경우 y오름 차순으로 정렬 후 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11650"/>Baekjoon_11650 좌표 정렬하기</a>
 */
public class Level7 {
    /**
     * <p> 좌표의 객체를 만들어 {@link Comparable} 구현하거나 또는 {@link java.util.Comparator} 만들어
     * <p> {@link Arrays#sort(int[])}를 이용하여 정렬한다.
     * <p> {@link Comparable} 와 {@link java.util.Comparator} x값이 같을 경우에는 y값 비교를 하도록 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Point[] arr = new Point[N];
//        Point2[] arr2 = new Point2[N];

        // Comparable 사용
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for (Point p : arr) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        // Comparator 사용
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            arr2[i] = new Point2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//        }
//        Comparator comp = (o1, o2) -> {
//            Point2 p1 = (Point2) o1;
//            Point2 p2 = (Point2) o2;
//
//            if (p1.x == p2.x) {
//                return p1.y - p2.y;
//            } else {
//                return p1.x - p2.x;
//            }
//        };

//        Arrays.sort(arr2, comp);

//        for (Point2 p : arr2) {
//            sb.append(p.x).append(" ").append(p.y).append("\n");
//        }

        System.out.println(sb);
    }

    static class Point implements Comparable {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            if (this.x == p.x) {
                return this.y - p.y;
            } else {
                return this.x - p.x;
            }
        }
    }

    static class Point2 {
        private int x;
        private int y;

        public Point2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


}
