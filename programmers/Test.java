package programmers;

public class Test {
  public static int countReplacements(String s, String t) {
    if (s == null || t == null) {
      throw new IllegalArgumentException("Input strings cannot be null");
    }

    int patternLength = t.length();
    int count = 0;
    boolean foundPattern;

    StringBuilder sb = new StringBuilder(s);
    StringBuilder result = new StringBuilder();

    do {
      foundPattern = false;
      int i = 0;
      while (i <= sb.length() - patternLength) {
        if (sb.substring(i, i + patternLength).equals(t)) {
          i += patternLength;
          foundPattern = true;
          count++;
        } else {
          result.append(sb.charAt(i));
          i++;
        }
      }
      // Append the remaining characters
      result.append(sb.substring(i));

      if (foundPattern) {
        sb = new StringBuilder(result);
        result.setLength(0);
      }
    } while (foundPattern);

    return count;
  }

  public static void main(String[] args) {
    // 100만 개의 'a'로 이루어진 문자열 생성
    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < 1_000_000; i++) {
//      sb.append('a');
//    }
    String s = "aaaaabbbbb";
    String t = "ab";

    long startTime = System.currentTimeMillis();
    int result = countReplacements(s, t);
    long endTime = System.currentTimeMillis();

    System.out.println("Original string length: " + s.length());
    System.out.println("Pattern to remove: " + t);
    System.out.println("Number of replacements: " + result);
    System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

    System.out.println(Long.MAX_VALUE);
  }
}
