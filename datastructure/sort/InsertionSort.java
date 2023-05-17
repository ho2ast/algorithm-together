package datastructure.sort;

public class InsertionSort {
    /**
     * <p> 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (가장 첫번째 타겟은 두번째 원소)
     * <p> 타겟이 되는 숫자가 이전 위치의 있던 원소보다 작으면 이전 위치 원소를 다음 위치로 옮긴다.
     * <p> 그 다음 타겟을 찾아 위와 같은 방법으로 반복한다.
     * <p> 타겟이 이전위치의 원소보다 작지 않을 경우 타겟을 작지 않은 원소 다음 위치에 넣는다.
     */
    public static void main(String[] args) {
        int[] arr1 = {7, 3, 2, 8, 9, 4, 6, 1, 5};
        insertionSort(arr1);
        for (int a : arr1) {
            System.out.print(a + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;

            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = target;
        }
    }
}
