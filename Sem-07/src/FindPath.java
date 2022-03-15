import java.util.*;

public class FindPath {

    private static void bfs(int[][] graph, boolean[] visited, int[] dist, int[] parent, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u = 1; u < graph.length; ++u) {
                if (graph[v][u] == 1 && !visited[u]) {
                    queue.add(u);
                    visited[u] = true;
                    dist[u] = dist[v] + 1;
                    parent[u] = v;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                graph[i][j] = in.nextInt();
            }
        }
        int start = in.nextInt();
        int finish = in.nextInt();

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        bfs(graph, visited, dist, parent, finish);

        if (!visited[start]) {
            System.out.println(-1);
        } else if (dist[start] == 0) {
            System.out.println(0);
        } else {
            System.out.println(dist[start]);
            List<Integer> path = new ArrayList<>();
            path.add(start);
            int v = start;
            while (v != finish) {
                v = parent[v];
                path.add(v);
            }
            for (int x : path) {
                System.out.print(x + " ");
            }
        }
    }
}
