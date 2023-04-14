package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * <p> 수 10개를 입력 받은 후 42로 나눈 나머지를 구한 후 다른값이 몇 개 인지 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/3052" />Baekjoon_3052 나머지</a>
 */
public class LevelH {
    /**
     * <p> 10개의 수를 42로 나눈 나머지를 배열로 저장 한다.
     * <p> 그 후 배열의 값을 {@link Set}에 저장후 해당 Set의 size를 구한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int[] numArr = new int[10];

        for (int i = 0; i < 10; i++) {
            numArr[i] = Integer.parseInt(br.readLine()) % 42;
        }

        for (int num : numArr) {
            set.add(num);
        }

        System.out.println(set.size());
    }
}
