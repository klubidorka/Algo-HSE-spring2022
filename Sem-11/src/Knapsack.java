import java.util.*;
import java.lang.*;

class Knapsack {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        int[] m = new int[N + 1];
        int[] c = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            m[i] = scan.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            c[i] = scan.nextInt();
        }

        int[][] A = new int[N + 1][M + 1];

        for (int i = 0; i <= M; i++) {
            A[0][i] = 0;
        }

        for (int s = 1; s <= N; s++) {
            for (int j = 0; j <= M; j++) {
                A[s][j] = A[s - 1][j];
                if (j >= m[s] && (A[s - 1][j - m[s]] + c[s] > A[s][j])) {
                    A[s][j] = A[s - 1][j - m[s]] + c[s];
                }
            }
        }

        System.out.print(A[N][M]);
    }
}