package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * <p> 수직선상의 좌표들이 주어질 때 이를 압축하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/18870"/>Baekjoon_18870 좌표 압축</a>
 */
public class Level11 {
    /**
     * <p> 좌표압축이란 주어진 좌표의 값을 대소관계만으로 표현하는것이다.
     * <p> 주어진 좌표의 가장 작은 값을 0으로 표현할 수 있다.
     * <p> 주어진 좌표를 정렬하여 기존 값과 비교 후
     * <p> 정렬된 좌표의 값과 같을 떄 정렬된 좌표의 인덱스를 출력한다.
     * <p> 주어진 수의 정렬은 {@link java.util.Comparator}를 이용하여 정렬한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        HashSet<Integer> set = new HashSet<>();


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }

        Object[] sortedArr = set.toArray();
        Arrays.sort(sortedArr);

        for (int i = 0; i < sortedArr.length; i++) {
            map.put((Integer) sortedArr[i], i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        System.out.println(sb);
    }
}
