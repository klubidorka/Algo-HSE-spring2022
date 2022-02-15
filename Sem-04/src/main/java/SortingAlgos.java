import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SortingAlgos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        QuickSort.sort(arr);
        for (int elem : arr) {
            System.out.printf("%d ", elem);
        }
        System.out.println();
    }
}

class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int q = partition(arr, l, r);
            sort(arr, l, q);
            sort(arr, q + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i++, j--);
        }
        return j;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// TODO
class MergeSort {

}