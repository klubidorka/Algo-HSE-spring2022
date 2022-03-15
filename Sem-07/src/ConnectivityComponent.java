import java.util.*;

public class ConnectivityComponent {
    private static List<Integer> bfs(List<List<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> comp = new ArrayList<>();
        queue.add(start);
        visited[start] = true;
        comp.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : graph.get(v)) {
                if (!visited[u]) {
                    visited[u] = true;
                    comp.add(u);
                    queue.add(u);
                }
            }
        }
        return comp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> compList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                compList.add(bfs(graph, visited, i));
            }
        }

        System.out.println(compList.size());
        for (List<Integer> integers : compList) {
            System.out.println(integers.size());
            for (int v : integers) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
