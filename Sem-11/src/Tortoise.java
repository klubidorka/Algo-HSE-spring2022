import java.util.*;
import java.lang.*;

class Tortoise {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int[][] desk = new int[N][M];
        int[][] ans = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                desk[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    ans[0][0] = desk[i][j];
                    continue;
                }
                if (i == 0) {
                    ans[i][j] = ans[i][j - 1] + desk[i][j];
                    continue;
                }
                if (j == 0) {
                    ans[i][j] = ans[i - 1][j] + desk[i][j];
                    continue;
                }
                ans[i][j] = Math.max(ans[i][j - 1], ans[i - 1][j]) + desk[i][j];
            }
        }
        System.out.print(ans[N - 1][M - 1]);
    }
}
