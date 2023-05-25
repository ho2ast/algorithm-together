package datastructure.sort;

public class CountingSort {
    /**
     * <p> 주어진 값이 몇 번 나왔는데 해당 값을 인덱스로 하는 곳에 카운팅
     * <p> 카운팅 한 배열을 누적합을 이용하여 계산
     * <p> 누적합 이므로 배열의 길이와 누적합의 최종합이 일치한다.
     * <p> 따라서 카운팅 배열의 원소-1을 하면 카운팅 인덱스에 해당 하는 숫자의 위지가 정해진다.
     */
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = new int[10];

        // 누적합 사용
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*31);	// 0 ~ 30
        }
        countingSort(arr);

        // 누적합 미사용. 수열의 크기와 수의 범위를 알고 있을 때
        for (int i = 0; i < 10; i++) {	// 수열의 크기 10
            arr1[(int) (Math.random() * 10)]++;	// 0 ~ 9
        };	// 0 ~ 30

        for(int i = 0; i < arr1.length; i++) {

            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr1.length; i++) {
            while(arr1[i]-- > 0) {	// arr 값이 0보타 클 경우
                System.out.print(i + " ");
            }
        }
    }

    private static void countingSort(int[] arr) {
        int[] countingArr = new int[31];
        int[] resultArr = new int[arr.length];

        for (int i : arr) {
            countingArr[i] += 1;
        }

//        prefixSum(countingArr);

        for (int i = arr.length - 1; i > -1; i--) {
            countingArr[arr[i]]--;
            resultArr[countingArr[arr[i]]] = arr[i];
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

        for (int a : countingArr) {
            System.out.print(a + " ");
        }
        System.out.println();

        for (int a : resultArr) {
            System.out.print(a + " ");
        }
    }

    private static void prefixSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
    }
}
