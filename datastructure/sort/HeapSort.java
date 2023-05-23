package datastructure.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 7, 4, 8, 9, 10, 45, 63, 33, 22};
        heapSort(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void heapSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        for (int i = getParentIndex(arr); i > -1; i--) {
            heapify(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    private static void heapify(int[] arr, int parentIndex, int lastIndex) {
        int leftChildIndex = (parentIndex * 2) + 1;
        int rightChildIndex = (parentIndex * 2) + 2;
        int largestIndex = parentIndex;

        if (leftChildIndex <= lastIndex && arr[largestIndex] < arr[leftChildIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex <= lastIndex && arr[largestIndex] < arr[rightChildIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != parentIndex) {
            swap(arr, largestIndex, parentIndex);
            heapify(arr, largestIndex, lastIndex);
        }
    }

    private static int getParentIndex(int[] arr) {
        return (arr.length - 1) / 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
