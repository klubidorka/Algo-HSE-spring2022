import java.io.*;
import java.util.*;

public class ArticulationPoints {
    static int timer = 0;

    private static void dfs(ArrayList<List<Integer>> graph, boolean[] visited, int[] enter, int[] ret, boolean[] res, int v, int p) {
        visited[v] = true;
        enter[v] = timer++;
        ret[v] = enter[v];
        int children = 0;
        for (int u : graph.get(v)) {
            if (u == p) {
                continue;
            }
            if (!visited[u]) {
                dfs(graph, visited, enter, ret, res, u, v);
                ret[v] = Math.min(ret[v], ret[u]);
                if (ret[u] >= enter[v] && p != -1) {
                    res[v] = true;
                }
                ++children;
            } else {
                ret[v] = Math.min(ret[v], enter[u]);
            }
        }
        if (p == -1 && children > 1) {
            res[v] = true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            if (v1 != v2) {
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
        }

        boolean[] visited = new boolean[n + 1];
        int[] enter = new int[n + 1];
        int[] ret = new int[n + 1];
        boolean[] res = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                dfs(graph, visited, enter, ret, res, i, -1);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (res[i]) {
                ans++;
            }
        }
        out.println(ans);
        for (int i = 1; i <= n; ++i) {
            if (res[i]) {
                out.print(i + " ");
            }
        }

        out.flush();
    }
}
