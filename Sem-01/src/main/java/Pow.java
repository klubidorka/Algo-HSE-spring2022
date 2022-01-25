/**
 * Решение задачи
 * https://leetcode.com/problems/powx-n/
 */
public class Pow {

    static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1.0 / x;
        }
        if (n % 2 == 0) {
            double temp = pow(x, n / 2);
            return temp * temp;
        }
        return x * pow(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(pow(1, -1));
    }
}
