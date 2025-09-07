package dp;
import java.util.Arrays;
class Solution63 {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[m - 1][n - 1] == 1){
            return 0;
        }
        dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(m, n, 0, 0,grid);
    }

    int solve(int m, int n, int i, int j,int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n || grid[i][j] == 1) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = 0, down = 0;

        //right
        if (j + 1 < n) {
            right = solve(m, n, i, j + 1,grid);
        }

        //down
        if (i + 1 < m) {
            down = solve(m, n, i + 1, j,grid);
        }

        return dp[i][j] = right + down;
    }
}