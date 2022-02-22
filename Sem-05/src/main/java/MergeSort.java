import java.util.Arrays;

public class MergeSort {
    static void sort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, n - mid);
        sort(left);
        sort(right);
        merge(array, left, right);
    }

    static void merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 6, 1, 7, 3, 9, -1, 4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
