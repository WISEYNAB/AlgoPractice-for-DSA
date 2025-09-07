package dp;
import java.util.Arrays;
class Solution62 {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(m,n,0,0);
    }

    int solve(int m,int n,int i,int j){
        if(i == m-1 && j == n-1){
            return 1;
        }

        if(i >= m || j >= n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = 0,down = 0;

        //right
        if(j + 1 < n){
            right = solve(m,n,i,j+1);
        }

        //down
        if(i + 1 < m){
            down = solve(m,n,i+1,j);
        }

        return dp[i][j] = right + down;
    }

}