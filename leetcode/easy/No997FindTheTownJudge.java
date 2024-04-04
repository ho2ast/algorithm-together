package leetcode.easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class No997FindTheTownJudge {


  public int findJudge(int n, int[][] trust) {
    Map<Integer, Integer> judge = new HashMap<>();
    ArrayList<Integer> judgeInvolve = new ArrayList<>();

    if (trust.length == 0 && n != 1) {
      return -1;
    } else if (n == 1 && trust.length == 0) {
      return 1;
    }

    for (int i = 0; i < trust.length; i++) {
      judgeInvolve.add(trust[i][0]);
      judge.put(trust[i][1], judge.getOrDefault(trust[i][1], 0) + 1);
    }

    Map.Entry<Integer, Integer> integerIntegerEntry = judge.entrySet().stream().filter(a -> a.getValue() == n - 1).findFirst().orElse(Map.of(0, 0).entrySet().stream().findFirst().get());

    return !judgeInvolve.contains(integerIntegerEntry.getKey()) && integerIntegerEntry.getValue() == n - 1 ? integerIntegerEntry.getKey() : -1;
  }
}
