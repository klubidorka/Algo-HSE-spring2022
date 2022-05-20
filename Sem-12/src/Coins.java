import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Coins {

    private static void read() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        coins = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }
        target = sc.nextInt();
    }

    private static void solve() {
        Collections.sort(coins);
        Collections.reverse(coins);
        ans = new ArrayList<>();
        for (Integer coin : coins) {
            while (coin <= target) {
                ans.add(coin);
                target -= coin;
            }
        }
        if (target > 0) {
            ans = null;
        }
    }

    private static void printResult() {
        if (ans == null) {
            System.out.println("No solution");
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        read();
        solve();
        printResult();
    }

    private static List<Integer> coins;
    private static List<Integer> ans;
    private static int target;
}
