package programmers.kakao2020internship;

/**
 * <p> 키패드가 주어질 때 어떤 손의 엄지손가락으로 누르는지 순서를 출력하세요.
 * <p> 문제 바로가기: <a href="https://school.programmers.co.kr/learn/courses/30/lessons/67256?language=java" />키패드 누르기</a>
 */
public class No1PushKeypad {

  public static void main(String[] args) {
    int[] num = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    String hand = "left";

    System.out.println(solution(num, hand));
  }

  public static String solution(int[] numbers, String hand) {
    StringBuilder answer = new StringBuilder();

    int lastLeft = 10;
    int lastRight = 12;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 0) {
        numbers[i] = 11;
      }

      if (numbers[i] % 3 == 1 && numbers[i] < 10) {
        lastLeft = numbers[i];
        answer.append("L");
      } else if (numbers[i] != 0 && numbers[i] % 3 == 0 && numbers[i] < 10) {
        lastRight = numbers[i];
        answer.append("R");
      } else {
        int leftDistance = Math.abs(lastLeft - numbers[i]);
        int rightDistance = Math.abs(lastRight - numbers[i]);

        if (leftDistance == 0) {
          leftDistance = 0;
        } else if ((leftDistance % 2 == 0 && leftDistance < 5) || leftDistance == 6) {
          leftDistance = 2;
        } else if (leftDistance == 1 || leftDistance == 3) {
          leftDistance = 1;
        } else if (leftDistance == 9 || leftDistance % 2 == 1) {
          leftDistance = 3;
        } else {
          leftDistance = 4;
        }

        if (rightDistance == 0) {
          rightDistance = 0;
        } else if (rightDistance % 2 == 0 && rightDistance < 5 || rightDistance == 6) {
          rightDistance = 2;
        } else if (rightDistance == 1 || rightDistance == 3) {
          rightDistance = 1;
        } else if (rightDistance == 9 || rightDistance % 2 == 1) {
          rightDistance = 3;
        } else {
          rightDistance = 4;
        }

        if (leftDistance < rightDistance) {
          answer.append("L");
          lastLeft = numbers[i];
        } else if (leftDistance > rightDistance) {
          answer.append("R");
          lastRight = numbers[i];
        } else {
          String h = hand.substring(0, 1).toUpperCase();
          answer.append(h);

          if (h.equals("R")) {
            lastRight = numbers[i];
          } else {
            lastLeft = numbers[i];
          }
        }
      }
    }

    return answer.toString();
  }
}
