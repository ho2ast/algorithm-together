package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> N개의 숫자가 공백없이 주어질 경우 숫자들의 합을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11720" />Baekjoon_11720 숫자의 합</a>
 */
public class LevelE {
    /**
     * <p> 첫번째 줄에 숫자의 개수 N이 주어지므로 N번 loop를 돌며</p>
     * <p> {@link String}의 charAt()을 이용하여 각 인덱스의 값을 받은 후</p>
     * <p> {@link Integer}의 parseInt()로 변환하여 합을 구해준다.</p>
     * <p> parseInt()는 String 타입을 파라미터로 사용하기 때문에 charAt()을 이용할 경우 기본형 type인 char가 리턴되므로String.vaue.</p>
     * <p> {@link String}의 valueOf()를 이용하여 String으로 변환 후 사용한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        br.close();

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        System.out.println(sum);
    }
}
