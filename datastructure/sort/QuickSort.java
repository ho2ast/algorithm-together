package datastructure.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr1 = {7, 1, 6, 4, 2, 3, 7};
        int[] arr2 = {7, 1, 6, 4, 2, 3, 7};
        int[] arr3 = {4, 1, 23, 4, 6, 87, 3, 4, 2, 5};
        int[] arr4 = {5, 3, 8, 9, 2, 4, 7};
        leftQuickSort(arr1, 0, arr1.length - 1);
        rightQuickSort(arr2, 0, arr2.length - 1);
        midQuickSort(arr3, 0, arr3.length - 1);
//        quickSortWithRecursion(arr4, 0, arr4.length - 1);

        System.out.print("leftQuickSort : ");
        for (int a : arr1) {
            System.out.print(a + " ");
        }

        System.out.println();
        System.out.print("rightQuickSort : ");
        for (int a : arr2) {
            System.out.print(a + " ");
        }

        System.out.println();
        System.out.print("midQuickSort : ");
        for (int a : arr3) {
            System.out.print(a + " ");
        }

        System.out.println();
        System.out.print("quickSortWithRecursion : ");
        for (int a : arr4) {
            System.out.print(a + " ");
        }
    }

    public static void quickSortWithRecursion(int[] work, int low, int high) {
        if (low >= high) return;

        int left = low, right = high;
        int pivot = work[(low + high) / 2];

        while (left <= right) {
            while (work[left] < pivot) left++;
            while (work[right] > pivot) right--;
            if (left > right) break;

            swap(work, left, right);
            left++;
            right--;
        }

        quickSortWithRecursion(work, low, right);
        quickSortWithRecursion(work, left, high);
    }

    private static void leftQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = leftPartition(arr, left, right);

        leftQuickSort(arr, left, pivot - 1);
        leftQuickSort(arr, pivot + 1, right);
    }

    private static int leftPartition(int[] arr, int left, int right) {
        int pivot = left;

        while (left < right) {
            while (arr[right] > arr[pivot] && left < right) {
                right--;
            }

            while (arr[left] <= arr[pivot] && left < right) {
                left++;
            }

            swap(arr, left, right);
        }

        swap(arr, pivot, left);

        return left;
    }

    private static void rightQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = rightPartition(arr, left, right);

        rightQuickSort(arr, left, pivot - 1);
        rightQuickSort(arr, pivot + 1, right);
    }

    private static int rightPartition(int[] arr, int left, int right) {
        int pivot = right;

        while (left < right) {
            while (arr[left] < arr[pivot] && left < right) {
                left++;
            }

            while (arr[right] >= arr[pivot] && left < right) {
                right--;
            }

            swap(arr, left, right);
        }

        swap(arr, pivot, right);

        return right;
    }

    private static void midQuickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = midPartition(arr, left, right);

        midQuickSort(arr, left, pivot - 1);
        midQuickSort(arr, pivot, right);
    }
    private static int midPartition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left > right) {
                break;
            }

            swap(arr, left, right);
            left++;
            right--;
        }

        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
