package dp;
class Solution {
    int m;
    int n;
    Integer[][] memo;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m + 1][n + 1];
        if(grid[m - 1][n - 1] == 1) return 0;
        return solve(0,0,grid);
    }

    int solve(int i,int j,int[][] grid){
        if(i == m - 1 && j == n - 1){
            return 1;
        }

        if(i >= m || j >= n || grid[i][j] == 1){
            return 0;
        }

        if(memo[i][j] != null) return memo[i][j];
        int down = solve(i + 1,j,grid);
        int right = solve(i,j + 1,grid);

        return memo[i][j] = down + right;
    }
}