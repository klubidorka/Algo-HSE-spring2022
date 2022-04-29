package dp;

import java.util.*;
import java.lang.*;

class Task2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        ArrayList<ArrayList<Integer>> desk = new ArrayList<>();
        int[][] ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                row.add(scan.nextInt());
            }
            desk.add(row);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    ans[0][0] = desk.get(i).get(j);
                    continue;
                }
                if (i == 0) {
                    ans[i][j] = ans[i][j - 1] + desk.get(i).get(j);
                    continue;
                }
                if (j == 0) {
                    ans[i][j] = ans[i - 1][j] + desk.get(i).get(j);
                    continue;
                }
                ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]) + desk.get(i).get(j);
            }
        }

        System.out.print(ans[N - 1][M - 1]);
    }
}