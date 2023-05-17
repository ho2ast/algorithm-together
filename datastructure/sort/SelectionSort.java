package datastructure.sort;

public class SelectionSort {
    /**
     * <p> 주어진 배열에서 최솟값을 찾는다.
     * <p> 최솟값을 맨 앞 자리와 교환한다.
     * <p> 맨 앞 자리를 제외한 나머지 값으로 위 과정을 반복한다.
     * <p> 반복 round 또한 size - 1회 하면 된다.
     * <p> size - 1 번째 까지 정렬이 되었다면 n번째는 가장 큰 값으로 변경되기 때문이다.
     */
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 1, 2, 5, 8, 7, 9};
        selectionSort(arr1);
        for (int a : arr1) {
            System.out.println(a + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
