package baekjoon.generalmath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * <p> 두 정수 A, B의 합을 출력하세요.</p>
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/10757"/>Baekjoon_10757 큰 수 A+B</a></p>
 */
public class LevelH {
    /**
     * <p> 큰 정수형 일 경우</p>
     * <p> 1. 큰 정수형 일 경우 {@link BigInteger} 클래스를 사용하여 연산해준다.</p>
     * <p> 2. 직접 덧셈 연산을 처리해준다.</p>
     * <p> 직접 덧셈 시 주어진 수를 각각 역순으로 배열에 담는다.</p>
     * <p> {@link String#charAt(int)}을 이용하는데 아스키코드로 변환되므로 '0'을 빼주면 그대로의 정수로 사용할 수 있다.</p>
     * <p> 각 배열의 첫번째 자리부터 덧셈을 한다. 두 수의 합이 10이 될 경우 나머지를 현재 자리에 올림 수1을 다음 자리에 더해준다.</p>
     * <p> 그 후 다시 역순으로 배열을 출력한다.</p>
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

//      1. BigInteger
//        BigInteger A = new BigInteger(st.nextToken());
//        BigInteger B = new BigInteger(st.nextToken());
//        System.out.println(A.add(B));

//      2. 직접 연산처리
        StringBuilder sb = new StringBuilder();
        String strA = st.nextToken();
        String strB = st.nextToken();

        int maxLength = Math.max(strA.length(), strB.length());

        int[] A = new int[maxLength + 1]; // 올림값이 생길 수 있으므로
        int[] B = new int[maxLength + 1];

        for (int i = strA.length() - 1, idx = 0; i >= 0; i--, idx++) {
            A[idx] = strA.charAt(i) - '0';
        }

        for (int i = strB.length() - 1, idx = 0; i >= 0; i--, idx++) {
            B[idx] = strB.charAt(i) - '0';
        }

        for (int i = 0; i < maxLength; i++) {
            int sum = A[i] + B[i];
            A[i] = sum % 10;
            A[i + 1] += (sum / 10);
        }

        if (A[maxLength] != 0) {
            sb.append(A[maxLength]);
        }

        for (int i = maxLength - 1; i > -1; i--) {
            sb.append(A[i]);
        }

        System.out.println(sb);
    }
}
