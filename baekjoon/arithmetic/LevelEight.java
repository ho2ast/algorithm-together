package baekjoon.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p> 불기연도를 서기연도로 변환하여 출력하세요.
 * <p> 문제 바로가기:  <a href="https://www.acmicpc.net/problem/18108" />불멸기원 계산</a>
 */
public class LevelEight {
    /**
     * 불기연도 에서 543을 빼주면 서기연도가 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int gap = 543;
        int buddhaEra = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(buddhaEra - gap);
    }
}
