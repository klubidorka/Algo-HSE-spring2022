package dp;

import java.util.*;
import java.lang.*;

class Task1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        long[] ans = new long[41];

        ans[1] = 2;
        ans[2] = 4;
        ans[3] = 7;

        for (int i = 4; i <= 40; i++) {
            ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3];
        }

        System.out.print(ans[N]);
    }
}