/**
 * Решение задачи
 * https://leetcode.com/problems/count-primes/
 */
public class Primes {

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Медленное решение задачи. Асимптотика O(N * sqrt(N))
     */
    public static int countPrimes(int n) {
        int primes = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes++;
            }
        }
        return primes;
    }

    /**
     * Решение задачи при помощи решета Эратосфена. Асимптотика O(N * log(log(N)))
     */
    public static int countPrimesFast(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] arr = new boolean[n];
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= n / 2; i++) {
            if (!arr[i]) {
                for (int k = 2; k * i < n; k++) {
                    arr[k * i] = true;
                }
            }
        }

        int primes = 0;
        for (boolean elem : arr) {
            if (!elem) {
                primes++;
            }
        }
        return primes;
    }

    /**
     * Подсчет скорости работы алгоритма
     */
    public static void speedTest(Runnable code) {
        long start = System.currentTimeMillis();
        code.run();
        System.out.printf("Execution took %d ms.\n", System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        speedTest(() -> countPrimesFast(1_500_000));
    }
}
