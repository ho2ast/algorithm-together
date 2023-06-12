package datastructure.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 7, 4, 8, 2, 10, 2, 63, 33, 22};
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
//            heapifyWithRecursive(arr, i, arr.length - 1);
            heapifyWithLoop(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
//            heapifyWithRecursive(arr, 0, i - 1);
            heapifyWithLoop(arr, 0, i - 1);
        }
    }

    private static void heapifyWithRecursive(int[] arr, int parentIndex, int lastIndex) {
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
            heapifyWithRecursive(arr, largestIndex, lastIndex);
        }
    }

    private static void heapifyWithLoop(int[] arr, int parentIndex, int lastIndex) {
        int leftChildIndex;
        int rightChildIndex;
        int largestIndex;

        while ((parentIndex * 2) + 1 <= lastIndex) {
            leftChildIndex = (parentIndex * 2) + 1;
            rightChildIndex = (parentIndex * 2) + 2;
            largestIndex = parentIndex;

            if (arr[leftChildIndex] > arr[largestIndex]) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex <= lastIndex && arr[rightChildIndex] > arr[largestIndex]) {
                largestIndex = rightChildIndex;
            }

            if (parentIndex == largestIndex) {
                return;
            }
            swap(arr, parentIndex, largestIndex);
            parentIndex = largestIndex;
        }
    }

    private static int getParentIndex(int[] arr) {
        return (arr.length - 2) / 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
