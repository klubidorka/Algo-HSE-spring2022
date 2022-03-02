import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution32 {
    private static void readGraph() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adjacencyMatrix = new ArrayList<>();
        visited = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            visited.add(false);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            adjacencyMatrix.add(row);
        }
    }

    private static void dfs(int node, int parent) {
        if (visited.get(node)) {
            foundCycles = true;
            return;
        }
        visited.set(node, true);
        List<Integer> nextNodes = adjacencyMatrix.get(node);
        for (int  nextNodeIdx = 0; nextNodeIdx < n; nextNodeIdx++) {
            if (nextNodes.get(nextNodeIdx) == 1 && nextNodeIdx != parent) {
                dfs(nextNodeIdx, node);
            }
        }
    }

    private static boolean visitedAllNodes() {
        for (boolean node : visited) {
            if (!node) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        readGraph();
        dfs(0, -1);
        if (foundCycles) {
            System.out.println("NO");
            return;
        }
        if (visitedAllNodes()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static List<List<Integer>> adjacencyMatrix;
    private static List<Boolean> visited;
    private static int n;
    private static boolean foundCycles = false;
}
