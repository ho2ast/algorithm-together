package leetcode.easy;

/**
 * <p> 문자열 s가 주어질 때 마지막 단어의 길이를 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/length-of-last-word/" />58. Length of Last Word</a>
 */
public class No58LengthOfLastWord {
  public static void main(String[] args) {
    String a = "   fly me   to   the moon  ";
    System.out.println(lengthOfLastWord(a));
  }

  /**
   * <p>주어진 문자열의 마지막 단어를 길이를 구하기 위해서는 {@link String} 클래스의 메서드를 이용하면 된다.
   * <p>{@link String#trim()} 메서드를 이용하여 문자열의 앞 뒤 공백을 없애준다.
   * <p>그 후 {@link String#lastIndexOf(String)} 메서드를 이용하여 마지막 공백의 index를 구해준 다음 문자열의 길이와 빼준다.
   * <p>또 다른 방법으로 {@link String#split(String)} 메서드를 이용하여 공백을 기준으로 배열로 만든 다음 마지막 요소의 길이를 구해준다.
   */
  public static int lengthOfLastWord(String s) {
    String trim = s.trim();
    return (trim.length() - 1) - trim.lastIndexOf(" ");

//    String[] s1 = s.split(" ");
//    return s1[s1.length - 1].length();
  }
}
