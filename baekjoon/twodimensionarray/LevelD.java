package baekjoon.twodimensionarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 도화지에 색종이를 여러 장 붙였을 때, 색종이의 넓이를 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2563"/>Baekjoon_2563 색종이</a></p>
 */
public class LevelD {
    /**
     * <p> 정사각형이므로 1, 1의 넓이는 1이다. 따라서 색종이의 범위를 2차원 배열에 값을 1로 두고 개수를 출력하면 된다.</p>
     * <p> 길이가 [100][100]인 이차원 배열 (행렬) 을 만든다.</p>
     * <p> 주어진 색종이의 위치에 해당 하는 배열의 값을 1로 변경한다.</p>
     * <p> 첫 번째 주어진 값이 column, 두 번째 값이 row를 의미 하나 row는 -99를 한 후 절대값으로 인덱스를 구한다.</p>
     * <p> 모두 변경 한 후 loop를 돌며 값이 1인 배열의 원소수를 카운트 하여 넓이를 구한다.</p>
     */
    static int[][] drawingPaper = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int caseCount = parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            st = new StringTokenizer(br.readLine());
            int column = parseInt(st.nextToken());
            int row = parseInt(st.nextToken());
            attachColoredPaper(drawingPaper, column, row);
        }

        System.out.println(getArea(drawingPaper));
    }

    private static void attachColoredPaper(int[][] drawingPaper, int column, int row) {
        int rowIndex = Math.abs(row - 99);
        for (int i = rowIndex; i > rowIndex - 10; i--) {
            for (int j = column; j < column + 10; j++) {
                drawingPaper[i][j] = 1;
            }
        }
    }

    private static int getArea(int[][] drawingPaper) {
        int area = 0;
        for (int[] ints : drawingPaper) {
            for (int i = 0; i < drawingPaper.length; i++) {
                if (ints[i] == 1) {
                    area++;
                }
            }
        }
        return area;
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
