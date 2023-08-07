package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> N개의 정수가 주어질 때 최솟값과 최댓값을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10818" />Baekjoon_10818 최소, 최대</a>
 */
public class LevelC {
    /**
     * <p> 주어진 정수의 개수 N 만큼 loop를 돌면서 공백으로 구분된 정수를 배열에 저장한다.</p>
     * <p> 정수는 1 이상이므로 최솟값 min을 1, 최댓값 max를 min으로 선언해준다.</p>
     * <p> min, max는 {@link Integer}의 MAX_VALUE 와 MIN_VALUE를 각각 할당 해준다.</p>
     * <p> 이후 배열을 loop돌면서 min보다 클 경우 max로 저장, 작을 경우 min으로 저장하여 max와 min을 구한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int min, max;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int num : numArr) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        System.out.println(min + " " + max);
    }
}
