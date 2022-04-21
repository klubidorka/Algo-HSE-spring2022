import java.util.*;

class Main {
	private static void readGraph() {
		Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	k = sc.nextInt();
		used = new boolean[n + 1];
		distances = new int[n + 1];
		graph = new ArrayList<>(n + 1);
		for (int i = 0; i <= n ; i++) {
			graph.add(new ArrayList<>());
		}
      	for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
              	int tmp = sc.nextInt();
          		if(tmp == 1) {
                	graph.get(i + 1).add(j + 1);
					graph.get(j + 1).add(i + 1);
              	}  
            
        	}
      	}
	}
	
	private static void dfs(int node, int parent) {
	    used[node] = true;
        for(int x : graph.get(node)) {
			if(!used[x]) {
                dfs(x, node);
            }
		}
	}
    //
	private static void bfs(int node) {
		used[node] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int x : graph.get(current)) {
				if(!used[x]) {
            		q.add(x);
					used[x] = true;
					distances[x] = distances[node] + 1;
            	}
			}
		}
	}

	private static int solve() {
		int max = -1;
		int maxIdx = 0;
		for (int i = 1; i <= n; i++) {
			if(distances[i] > max) {
				max = distances[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	
	public static void main(String[] args) {
		readGraph();
		bfs(k);
		System.out.println(solve());
  	}

	private static List<List<Integer>> graph;
	private static boolean[] used;
	private static int[] distances;
	private static int n;
	private static int k;
}

