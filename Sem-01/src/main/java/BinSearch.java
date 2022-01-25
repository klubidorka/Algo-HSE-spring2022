public class BinSearch {
    static int N = 10;
    static int[] Arr = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    };

    /**
     * Функция ищет число target в массиве Arr при помощи бинарного поиска.
     * @param target
     * @return индекс самого левого вхождения числа target, если оно есть в массиве, иначе -1
     */
    public static int findTarget(int target) {
        int L = -1;
        int R = N;
        while (R - L > 1) {
            int mid = (R + L) / 2;
            if (Arr[mid] >= target)
                R = mid;
            else
                L = mid;
        }
        if (R != N && Arr[R] == target)
            return R;
        else
            return -1;

    }

    public static void main(String[] args) {
        findTarget(5);
    }
}
