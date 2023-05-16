package datastructure.sort;

public class BubbleSort {
    /**
     * <p> 인접합 원소와 비교 후 위치를 변경한다.
     * <p> 총 라운드는 배열 크기 - 1 번 진행되고,
     * <p> 각 라운드별 비교 횟수는 배열 크기 - 라운드 횟수 만큼 비교한다.
     * <p> 기존방식은 만약 모든 원소들이 정렬되어 있는 상황(Best Case)이어도 swap은 발생하지 않지만 모든 라운드를 실행한다.
     * <p> 그럴 경우 swap 실행 여부를 판단하는 flag를 두어 swap 실행이 되지 않았을 경우 정렬을 곧바로 중단 할 수 있다.
     */
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5, 6, 7};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        bubbleSort(arr);
        bubbleSortWithSwapFlag(arr2);
        for (int a : arr) {
            System.out.println(a + " ");
        }
    }

    // 기존방식
    private static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] - arr[j + 1] > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // swap 여부 확인 방식
    private static void bubbleSortWithSwapFlag(int[] arr) {
        boolean didSwap = false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] - arr[j + 1] > 0) {
                    swap(arr, j, j + 1);
                    didSwap = true;
                }
            }

            if (!didSwap) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
