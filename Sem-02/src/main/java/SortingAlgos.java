import java.util.Arrays;

public class SortingAlgos {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    sorted = false;
                }
            }
            if (sorted) {
                return;
            }
        }
    }


    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j > 0 && arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                j--;
            }
        }
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 19, 3, 4, 10, 6};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
