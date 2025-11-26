package dp;

class Solution {
    int m;
    int n;
    int M;
    Integer[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        M = 1000000007;
        m = grid.length;
        n = grid[0].length;
        dp = new Integer[m + 1][n + 1][k + 1];
        return paths(0,0,k,grid,0) % M;
    }

    int paths(int i,int j,int k,int[][] grid,int sum){
        if(i >= m || j >= n){
            return 0;
        }

        if(i == m - 1 && j == n - 1){
            sum += grid[i][j];
            if(sum % k == 0){
                return 1;
            } else {
                return 0;
            }
        }

        if(dp[i][j][sum % k] != null){
            return dp[i][j][sum % k];
        }

        int down = paths(i + 1,j,k,grid,sum + grid[i][j]) % M;
        int right = paths(i,j+1,k,grid,sum + grid[i][j]) % M;

        return dp[i][j][sum % k] = (down + right) % M;
    }
}