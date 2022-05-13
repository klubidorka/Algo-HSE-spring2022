import java.io.*;
import java.util.*;

public class Bridges {
    private static void dfs(int v, int p) {
        visited[v] = true;
        enter[v] = timer++;
        ret[v] = enter[v];
        for (Edge e : graph.get(v)) {
            int u = e.to;
            int num = e.num;
            if (num == p)
                continue;
            if (!visited[u]) {
                dfs(u, num);
                ret[v] = Math.min(ret[v], ret[u]);
                if (ret[u] > enter[v])
                    res.add(num);
            } else {
                ret[v] = Math.min(ret[v], enter[u]);
            }
        }
    }

    private static void readGraph() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i <= n; ++i)
            graph.add(new ArrayList<>());
        for (int i = 1; i <= m; ++i) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            if (v1 != v2) {
                graph.get(v1).add(new Edge(v2, i));
                graph.get(v2).add(new Edge(v1, i));
            }
        }
    }

    private static void solve() {
        visited = new boolean[n + 1];
        enter = new int[n + 1];
        ret = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (!visited[i])
                dfs(i, -1);
        }
        Collections.sort(res);
    }

    private static void printAnswer() {
        PrintWriter out = new PrintWriter(System.out);
        out.println(res.size());
        for (int x : res)
            out.print(x + " ");
        out.flush();
    }

    public static void main(String[] args) {
        readGraph();
        solve();
        printAnswer();
    }

    private static class Edge implements Comparable<Edge> {
        public int to;
        public int num;

        public Edge(int to, int num) {
            this.to = to;
            this.num = num;
        }

        public int compareTo(Edge edge) {
            return Integer.compare(this.num, edge.num);
        }
    }

    private static int n;
    private static int m;
    private static int timer = 0;
    private static final List<List<Edge>> graph = new ArrayList<>();
    private static final List<Integer> res = new ArrayList<>();
    private static int[] enter;
    private static int[] ret;
    private static boolean[] visited;
}
