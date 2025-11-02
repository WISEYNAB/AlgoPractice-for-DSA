package Arrays;
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<String> guard = new HashSet<>();
        Set<String> wall = new HashSet<>();
        boolean[][] occupied = new boolean[m][n];

        for (int[] g : guards) {
            guard.add(g[0] + "," + g[1]);
        }
        for (int[] w : walls) {
            wall.add(w[0] + "," + w[1]);
        }

        for (int[] g : guards) {
            int i = g[0];
            int j = g[1];

            occupied[i][j] = true;

            int u = i + 1, p = j;
            while (u < m && !wall.contains(u + "," + p) && !guard.contains(u + "," + p)) {
                occupied[u][p] = true;
                u++;
            }

            u = i - 1;
            p = j;
            while (u >= 0 && !wall.contains(u + "," + p) && !guard.contains(u + "," + p)) {
                occupied[u][p] = true;
                u--;
            }

            u = i;
            p = j + 1;
            while (p < n && !wall.contains(u + "," + p) && !guard.contains(u + "," + p)) {
                occupied[u][p] = true;
                p++;
            }

            u = i;
            p = j - 1;
            while (p >= 0 && !wall.contains(u + "," + p) && !guard.contains(u + "," + p)) {
                occupied[u][p] = true;
                p--;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!occupied[i][j] && !wall.contains(i + "," + j) && !guard.contains(i + "," + j)) {
                    count++;
                }
            }
        }

        return count;
    }
}
