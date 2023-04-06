package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p> 구매한 각 물건의 가격과 개수, 구매한 물건들의 총 금액이 주어질 때 일치하는지 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/25304" />Baekjoon_25304 영수증</a>
 */
public class LevelD {
    /**
     * <p> 첫째 줄에는 영수증에 적힌 총 금액 X가 주어진다.
     * <p> 둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수 N이 주어진다.
     * <p> 이후 N개의 줄에는 각 물건의 가격 a와 개수 b가 공백을 사이에 두고 주어진다.
     * <p> N의 값에 따라 반복문을 돌면 물건 값의 합계를 구해준다.
     */
    public static void main(String[] args) throws IOException {
        String result = "No";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int price, quantity;
        int sum = 0;
        int count = 0;


        while (count < N) {
            st = new StringTokenizer(br.readLine());
            price = Integer.parseInt(st.nextToken());
            quantity = Integer.parseInt(st.nextToken());
            sum += price * quantity;
            count++;
        }
        br.close();

        if (X == sum) {
            result = "Yes";
        }

        System.out.println(result);
    }
}
