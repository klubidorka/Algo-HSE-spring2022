import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimalProductSubset {
    private static void read() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numbers = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
    }

    private static void solve() {
        assert numbers.size() > 0;
        int negatives = 0;
        int zeros = 0;

        for (int num : numbers) {
            if (num == 0)
                zeros++;
            else if (num < 0)
                negatives++;
        }

        if (negatives > 0) {
            if (negatives % 2 == 0) {
                int greatestMin = numbers.stream().filter(x -> x < 0).max(Integer::compareTo).orElse(0);
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == greatestMin)
                        numbers.set(i, 0);
                }
            }
            for (int num : numbers) {
                if (num != 0)
                    minProduct *= num;
            }
        } else {
            if (zeros > 0)
                minProduct = 0;
            else
                minProduct = numbers.stream().min(Integer::compareTo).orElse(0);
        }
    }


    private static void printResult() {
        System.out.println(minProduct);
    }

    public static void main(String[] args) {
        read();
        solve();
        printResult();
    }

    private static List<Integer> numbers;
    private static long minProduct = 1;
}
