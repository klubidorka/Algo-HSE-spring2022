package abstract_segment_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Решение задачи
 * https://informatics.msk.ru/mod/statements/view.php?id=42416&chapterid=3313#1
 */
public class Task {
    private static void read() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ints = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ints.add(sc.nextInt() == 0 ? 1 : 0); // Такой формат позволит использовать ДО на сумму
        }

        int queriesSize = sc.nextInt();
        queries = new ArrayList<>(queriesSize);
        for (int i = 0; i < queriesSize; i++) {
            int left = sc.nextInt() - 1; // Так как в задаче нумерация с единицы, а у нас с нуля
            int right = sc.nextInt(); // Не вычитаем, так как правая граница включается в задаче, а у нас нет
            queries.add(List.of(left, right));
        }
    }

    private static void solve() {
        STSum countZerosST = new STSum(ints);
        answer = new ArrayList<>(queries.size());
        for (List<Integer> query : queries) {
            answer.add(countZerosST.resultOnSegment(query.get(0), query.get(1)));
        }
    }

    private static void writeAnswer() {
        answer.forEach(k -> System.out.printf("%d ", k));
        System.out.println();
    }

    public static void main(String[] args) {
        read();
        solve();
        writeAnswer();
    }

    private static List<Integer> ints;
    private static List<List<Integer>> queries;
    private static List<Integer> answer;
}
