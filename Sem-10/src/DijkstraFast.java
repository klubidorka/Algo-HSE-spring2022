import java.io.*;
import java.util.*;

public class DijkstraFast {
    static int INF = 2009000999;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int it = 0; it < t; ++it) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; ++i) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                int weight = in.nextInt();
                graph.get(v1).add(new Edge(v2, weight));
                graph.get(v2).add(new Edge(v1, weight));
            }

            int s = in.nextInt();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n];
            int[] dist = new int[n];
            Arrays.fill(dist, INF);
            dist[s] = 0;
            pq.add(new Node(dist[s], s));
            while (!pq.isEmpty()) {
                int v = pq.remove().vertex;
                if (visited[v]) {
                    continue;
                }
                visited[v] = true;

                for (Edge e : graph.get(v)) {
                    int to = e.to;
                    int weight = e.weight;
                    if (dist[to] > dist[v] + weight) {
                        dist[to] = dist[v] + weight;
                        pq.add(new Node(dist[to], to));
                    }
                }
            }

            for (int i = 0; i < n; ++i) {
                out.print(dist[i] + " ");
            }
            out.println();
        }
        out.flush();
    }
}

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Node implements Comparable<Node> {
    public int dist;
    public int vertex;

    public Node(int dist, int vertex) {
        this.dist = dist;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.dist, node.dist);
    }
}
