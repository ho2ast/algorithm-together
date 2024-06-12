package baekjoon.chanhyeng.weeks6;

import java.io.*;

/**
 * <p> 교수님의 말씀을 재귀를 이용하여 출력하세요.
 * <p> 문제 바로가기: <a href="https://www.acmicpc.net/problem/17478"/>Baekjoon_17478 재귀함수가 뭔가요?</a>
 */
public class Baekjoon17478 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;

  public static void main(String[] args) throws IOException {

    bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
    bw.newLine();

    N = Integer.parseInt(br.readLine());

    recursive(0);

    bw.flush();
    bw.close();
    br.close();
  }

  public static void recursive(int n) throws IOException {
    String question = "\"재귀함수가 뭔가요?\"";
    String answer1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    String answer2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    String answer3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
    String answer4 = "라고 답변하였지.";
    String answer5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";


    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append("____");
    }

    if (n == N) {
      bw.write(sb + question);
      bw.newLine();
      bw.write(sb + answer5);
      bw.newLine();
      sb.append(answer4);
      bw.append(sb);
      bw.newLine();
      return;
    }

    bw.write(sb + question);
    bw.newLine();
    bw.write(sb + answer1);
    bw.newLine();
    bw.write(sb + answer2);
    bw.newLine();
    bw.write(sb + answer3);
    bw.newLine();
    recursive(n + 1);

    sb.append(answer4);
    bw.append(sb);
    bw.newLine();
  }
}
