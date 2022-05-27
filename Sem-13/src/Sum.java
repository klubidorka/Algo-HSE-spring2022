import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sum {

    private static void preparation() {
        prefix = new ArrayList<>(array.size());
        prefix.add(array.get(0));
        for (int i = 1; i < array.size(); i ++) {
            prefix.add(i, array.get(i) + prefix.get(i - 1));
        }
    }

    private static void preparation2() {
        prefix = new ArrayList<>(array.size());
        int counter = 0;
        for (Integer integer : array) {
            counter += integer;
            prefix.add(counter);
        }
    }

    private static int sum(int left, int right) {
        if (left == 0)
            return prefix.get(right);
        return prefix.get(right) - prefix.get(left - 1);
    }

    private static void read() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            array.add(sc.nextInt());
        }
    }

    private static int checker(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans += array.get(i);
        }
        return ans;
    }

    private static void runTest(int left, int right) {
        if (checker(left, right) != sum(left, right))
            System.out.printf("FAIL, checker output %d, output %d\n", checker(left, right), sum(left, right));
        else
            System.out.println("OK");
    }

    private static void runTests() {
        runTest(1, 3);
        runTest(0, 4);
        runTest(1, 1);
        runTest(3, 4);
    }

    public static void main(String[] args) {
        read();
        preparation2();
        runTests();
    }

    private static List<Integer> array;
    private static List<Integer> prefix;
}