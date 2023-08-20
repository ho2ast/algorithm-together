package leetcode.easy;

/**
 * <p> 주어진 양의 정수 x의 제곱근을 구하세요.
 * <p> 문제 바로가기: <a href="https://leetcode.com/problems/sqrtx/" />69. Sqrt(x)</a>
 */
public class No69Sqrt {
  public static void main(String[] args) {
    float a = 1 + (36 - 1) / 2;
    System.out.println(a);
  }

  /**
   * <p>주어진 정수의 제곱근을 구하기 위해서는 {@link Math#sqrt(double)} 함수를 이용하면 되지만 문제에서는 내장된 함수를 사용할 수 없다고 했다.
   * <p>가장 먼저 떠오른 방법은 가장 무식한 방법으로 1부터 시작하여 제곱을한 값을 주어진 x와 비교하여 같거나 다음수의 제곱보다 작을 경우 해당 수를 반환 해준다.
   * <p>당연히 시간초과.. 다른 해결 방법을 생각 해보자
   * <p>도저히 모르겠어서 힌트를 보았다.. 힌트에는 이진검색을 통해 범위를 줄여가며 값을 구하는 방식을 사용했다.
   * <p>while 문을 돌며 start = 1, end = x로 두고 mid = start + (end - start) / 2를 이용하여 중간 값을 구해준다.
   * <p>해당 중간 값의 제곱이 x와 같을 경우 x를 그대로 반환한다.
   * <p>x보다 클 경우 end값을 mid - 1로 하고 작을 경우 start = mid + 1로 변경한 후 위의 과정을 반복해준다.
   * <p>start <= end 일 경우 while을 중지하고 end값을 리턴해준다..
   */
  public static int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }

//    int index = 1;
//
//    while (true) {
//      int square = index * index;
//
//      if (square == x) {
//        break;
//      } else if (square < x && x < (index + 1) * (index + 1)) {
//        break;
//      }
//
//      index++;
//    }
//    return index;

    int start = 1;
    int end = x;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (mid == x / mid) {
        return mid;
      } else if (mid > x / mid) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return end;
  }
}
