import java.util.*;

public class DijkstraSlow {
    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int f = in.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                graph[i][j] = in.nextInt();
            }
        }

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        for (int i = 0; i < n; ++i) {
            int v = -1;
            for (int j = 1; j <= n; ++j) {
                if (!visited[j] && (v == -1 || dist[j] < dist[v])) {
                    v = j;
                }
            }

            if (v == -1 || dist[v] == INF) {
                break;
            }
            visited[v] = true;

            for (int j = 1; j <= n; ++j) {
                if (graph[v][j] != -1 && dist[j] > dist[v] + graph[v][j]) {
                    dist[j] = dist[v] + graph[v][j];
                }
            }
        }

        if (!visited[f]) {
            System.out.println(-1);
        } else {
            System.out.println(dist[f]);
        }
    }
}

