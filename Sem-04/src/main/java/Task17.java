import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(solve(x));
    }

    private static long solve(int x) {
        long result = 0;
        long a = 1;
        long b = 1;

        for (int i = 0; i < x; i++) {
            long aElem = a * a;
            long bElem = b * b * b;

            if (aElem == bElem) {
                a++;
                i--;
                continue;
            }

            if (aElem > bElem) {
                result = bElem;
                b++;
            } else {
                result = aElem;
                a++;
            }
        }

        return result;
    }
}
