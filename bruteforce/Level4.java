package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> MxN의 보드가 주어졌을 때 8x8의 체스판으로 만들기위해 최소한 으로 칠해야 하는 사각형의 최솟값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/1018"/>Baekjoon_1018 체스판 다시 칠하기</a>
 */
public class Level4 {
    /**
     * <p> 체스판의 크기(8x8)에 맞춰 주어진 사각형들을 검사한다.
     * <p> 해당 크기내의 사각형의 색을 조건에 맞게 검사하여 바꿔야 하는 경우의 수를 구한다.
     */
    static int minCount = 64;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = String.valueOf(s.charAt(j)).equals("W");
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(minCount);
    }

    public static void find(int x, int y) {
        int count = 0;
        boolean TF = arr[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (arr[i][j] != TF) {
                    count++;
                }

                TF = !TF;
            }
            TF = !TF;
        }

        /*
         *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
         *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
         *  색칠 할 개수(64 - count) 중 최솟값을 count 에 저장
         */
        count = Math.min(count, 64 - count);
        minCount = Math.min(minCount, count);
    }

}
