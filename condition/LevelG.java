package condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <p> 3개의 주사위 눈이 주어질 때, 조건에 따라 상금을 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/2480" />Baekjoon_2480 주사위 세개</a>
 *
 */
public class LevelG {
    /**
     * <p> 조건은 다음과 같다.
     * <ol>
     *     <li>같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.</li>
     *     <li>같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.</li>
     *     <li>모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.</li>
     * </ol>
     * <p> 최초 풀이 시 세 값을 모두 비교하려고 했으나 모두 다를 경우 세수의 크기 비교가 필요하여 리스트로 계산
     * <p> 두 가지 풀이 모두 작성
     * <p>
     * <p> 다음은 최초 풀이 시 생각한 경우의 수
     * <p> 1,2번이 같은 경우: 2,3번 비교 -> 모두 동일 or 1,2번 동일
     * <p> 1,2번이 다른 경우: 2,3번 비교, 1,3번 비교 -> 2,3번 동일 or 1,3번 동일 or 모두 다름
     * <p>
     * <p> List 변환 후 계산 방법
     * <p> 받은 세 수를 List 로 만들어 정렬한다.
     * <p> 반복문을 통해 {@link java.util.Collections}의 frequency()를 사용하여 중복인 원소를 개수를 구한다.
     * <p> 중복된 값이 2개 이상 나올 경우 해당 값을 주사위의 눈으로 대입 후 상금을 계산한다.

     */
    public static void main(String[] args) throws IOException {
        int reward = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        // 1번째 풀이 124ms 소요
        if (first != second && second != third && first != third) {
            reward = third(Math.max(first, Math.max(second, third)));
        } else if (first == second && first == third) {
            reward = jackpot(first);
        } else if (first == second || first == third) {
            reward = second(first);
        } else {
            reward = second(first);
        }

        System.out.println(reward);

        // 2번째 풀이 132ms 소요
        ArrayList<Integer> list = new ArrayList<>(List.of(first, second, third));
        list.sort(Integer::compareTo);

        for (int i = 0; i < list.size(); i++) {
            int duplicateNum = Collections.frequency(list, list.get(i));

            if (duplicateNum == 3) {
                reward = jackpot(list.get(i));
                break;
            } else if (duplicateNum == 2) {
                reward = second(list.get(i));
                break;
            }

            if (i == 2) {
                reward = third(list.get(i));
            }
        }

        System.out.println(reward);
    }

    private static int jackpot(int luckyNumber) {
        return (luckyNumber * 1000) + 10000;
    }

    private static int second(int luckyNumber) {
        return (luckyNumber * 100) + 1000;
    }

    private static int third(int luckyNumber) {
        return luckyNumber * 100;
    }
}
