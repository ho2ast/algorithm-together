package programmers.kakao2018blindrecruitment;

public class SecretMap {
  public static void main(String[] args) {
    int n = 5;
    int[] arr1 = {9, 20, 28, 18, 11};
    int[] arr2 = {30, 1, 21, 17, 28};

    solution(5, arr1, arr2);
  }

  public static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    String[][] tempAnswer = new String[2][n];

    for (int i = 0; i < arr1.length; i++) {
      StringBuilder sb = new StringBuilder();
      String binaryString = Integer.toBinaryString(arr1[i]);

      int zeroLength = 5 - binaryString.length();

      for (int j = 0; j < zeroLength; j++) {
        sb.append("0");
      }
      sb.append(binaryString);

      for (int j = 0; j < n; j++) {
        if (sb.charAt(j) == 48) {
          tempAnswer[0][i] = " ";
        } else {
          tempAnswer[0][i] = "#";
        }
      }

    }

    for (int i = 0; i < arr2.length; i++) {
      StringBuilder sb = new StringBuilder();
      String binaryString = Integer.toBinaryString(arr2[i]);

      int zeroLength = 5 - binaryString.length();

      for (int j = 0; j < zeroLength; j++) {
        sb.append("0");
      }
      sb.append(binaryString);

      for (int j = 0; j < n; j++) {
        if (sb.charAt(j) == 48) {
          tempAnswer[1][i] = " ";
        } else {
          tempAnswer[1][i] = "#";
        }
      }

    }

    for (int i = 0; i < 2; i++) {
      StringBuilder mapNumber = new StringBuilder();
      for (int j = 0; j < n; j++) {
        mapNumber.append(tempAnswer[i][j]);
      }
    }


    return answer;
  }
}
