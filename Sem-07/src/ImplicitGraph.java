import java.util.*;

public class ImplicitGraph {

    static class Cell {
        int i;
        int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void bfs(char[][] field, boolean[][] visited, Cell start) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(start);
        visited[start.i][start.j] = true;
        while (!queue.isEmpty()) {
            Cell v = queue.poll();
            for (int di = -1; di <= 1; ++di) {
                for (int dj = -1; dj <= 1; ++dj) {
                    if (Math.abs(di) + Math.abs(dj) == 1) {
                        int new_i = v.i + di;
                        int new_j = v.j + dj;
                        if (0 <= new_i && new_i < field.length && 0 <= new_j && new_j < field[0].length && field[new_i][new_j] == '#' && !visited[new_i][new_j]) {
                            queue.add(new Cell(new_i, new_j));
                            visited[new_i][new_j] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine(); // необходимо для корректного использования in.nextLine() дальше

        char[][] field = new char[n][m];
        for (int i = 0; i < n; ++i) {
            field[i] = in.nextLine().toCharArray();
        }

        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (field[i][j] == '#' && !visited[i][j]) {
                    ans++;
                    bfs(field, visited, new Cell(i, j));
                }
            }
        }

        System.out.println(ans);
    }
}
