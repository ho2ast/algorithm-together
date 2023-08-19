package leetcode.easy;

/**
 * <p> 두 Binary String이 주어질 때, 합을 구하세요..
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/add-binary/" />67. Add Binary</a>
 */
public class No67AddBinary {

  public static void main(String[] args) {
    System.out.println(addBinary("1010", "1011"));
  }

  /**
   * <p>문자열로 된 두 이진수의 합을 구해야한다. 이진수의 합에서 두 수의 합이 2일 경우 1을 다음 수로 넘겨준다.
   * <p>주어진 이진수의 길이를 먼저 구한 뒤 길이가 짧은 수를 긴 쪽에 맞추어 준다.
   * <p>이 때 문자열의 앞에 0을 추가하여 길이를 맞춰 준다.
   * <p>그 후 뒤에서부터 loop를 돌며 두 값의 합을 구해준다.
   */
  public static String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();

    int aLength = a.length();
    int bLength = b.length();
    int abs = Math.abs(aLength - bLength);

    StringBuilder aBuilder = new StringBuilder(a);
    StringBuilder bBuilder = new StringBuilder(b);

    if (abs != 0) {
      if (aLength > bLength) {
        for (int i = 0; i < abs; i++) {
          bBuilder.insert(0, "0");
        }
      } else {
        for (int i = 0; i < abs; i++) {
          aBuilder.insert(0, "0");
        }
      }
    }

    a = aBuilder.toString();
    b = bBuilder.toString();

    int carryNum = 0;

    for (int i = a.length() - 1; i > -1; i--) {
      int sum = a.charAt(i) + b.charAt(i) + carryNum;

      if (sum == 98 || sum == 96) {
        result.insert(0, "0");
        if (a.charAt(i) == 49) carryNum = 1;
      } else if (sum == 99) {
        result.insert(0, "1");
        carryNum = 1;
      } else {
        result.insert(0, "1");
        carryNum = 0;
      }
    }
    if (carryNum == 1) result.insert(0, "1");
    return result.toString();
  }
}
