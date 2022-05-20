import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TasksOrder {
    private static void read() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> times = new ArrayList<>(n);
        List<Integer> costs = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            times.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            costs.add(sc.nextInt());
        }
        tasks = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tasks.add(new Task(i, costs.get(i) / (double)times.get(i)));
        }
    }

    private static void solve() {
        Collections.sort(tasks);
        for (Task task : tasks) {
            answer.add(task.index);
        }
    }

    private static void printResult() {
        System.out.println(answer);
    }

    public static void main(String[] args) {
        read();
        solve();
        printResult();
    }

    static class Task implements Comparable<Task> {
        int index;
        double costPerDay;

        Task(int idx, double cost) {
            index = idx;
            costPerDay = cost;
        }

        @Override
        public int compareTo(Task o) {
            return Double.compare(o.costPerDay, this.costPerDay);
        }
    }

    private static List<Task> tasks;
    private static List<Integer> answer;
}
