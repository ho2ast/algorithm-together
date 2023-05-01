package twodimensionarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> N*M 행렬 두개가 주어 졌을 때, 두 행렬의 덧셈을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/2738"/>Baekjoon_2738 행렬 덧셈</a></p>
 */
public class LevelA {
    /**
     * <p> M*N행렬 이므로 M번째 줄 까지 첫번째 행렬, 그 이후는 두번째 행렬이다.</p>
     * <p> 각 줄의 값을 배열에 저장 후 첫 번째 행렬이 끝나고 두번 째 행렬이 시작될 때 기존 배열의 값과 더해준다.</p>
     * <p> 그 후 해당 배열을 주어진 행렬의 형태로 만들어 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        int[] intArr = new int[N * M];

        int i = 0;
        String numbers = "";

        while (!(numbers = br.readLine()).equals("")) {
            st = new StringTokenizer(numbers);
            if (i == (N * M)) {
                i = 0;
            }
            while (st.hasMoreTokens()) {
                intArr[i] = parseInt(st.nextToken()) + intArr[i];
                i++;
            }
        }

        for (int j = 0; j <intArr.length; j++) {
            if (j != 0 && j % M == 0) {
                sb.append("\n");
            }
            sb.append(intArr[j]).append(" ");
        }

        System.out.println(sb);
    }

    private static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}
