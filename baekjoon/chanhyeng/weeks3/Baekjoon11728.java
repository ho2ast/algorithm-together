package baekjoon.chanhyeng.weeks3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * <p> 두 배열이 주어졌을 때 두 배열을 합치고 합친 배열을 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/11728"/>Baekjoon_11728 배열 합치기</a>
 */
public class Baekjoon11728 {
  /**
   * <p> 일반적으로 생각해보면 두 배열이 주어졌을 때 두 길이를 합친 배열을 만든 후
   * <p> 이중 반복문을 통해 배열에 넣어준 후 정렬을 이용한다.
   * <p> 하지만 n^2의 시간 복잡도로 실패.
   * <p> 투포인터로 접근해보자.
   * <p> 시작 포인터을 0으로 잡고 두 배열의 값을 비교해준다. 작은 값을 넣어주고 해당 인덱스 ++.
   * <p> 이렇게 쭉 진행하다가 한쪽 인덱스가 하나의 배열 사이즈를 넘기면 반복문을 끝내고.
   * <p> 남은 배열의 값들을 다 넣어준다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int arr1Size = Integer.parseInt(st.nextToken());
    int arr2Size = Integer.parseInt(st.nextToken());

    int[] arr1 = new int[arr1Size];
    int[] arr2 = new int[arr2Size];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < arr1Size; i++) {
      arr1[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < arr2Size; i++) {
      arr2[i] = Integer.parseInt(st.nextToken());
    }

    int arr1Index = 0;
    int arr2Index = 0;

    // 최대 2백만건
    while (arr1Index < arr1Size && arr2Index < arr2Size) {
      if (arr1[arr1Index] >= arr2[arr2Index]) {
        bw.write(String.valueOf(arr2[arr2Index++]));
        bw.write(" ");
      } else {
        bw.write(String.valueOf(arr1[arr1Index++]));
        bw.write(" ");
      }
    }

    if (arr1Index == arr1Size) {
      for (int i = arr2Index; i < arr2Size; i++) {
        bw.write(String.valueOf(arr2[i]));
        bw.write(" ");
      }
    }

    if (arr2Index == arr2Size) {
      for (int i = arr1Index; i < arr1Size; i++) {
        bw.write(String.valueOf(arr1[i]));
        bw.write(" ");
      }
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
