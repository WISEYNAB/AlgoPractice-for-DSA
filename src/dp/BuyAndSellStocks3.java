package dp;
import java.util.Arrays;

class Solution123{
    int n;
    int[][][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n + 1][2][3];
        for(int[][] row : dp){
            for(int[] mat : row){
                Arrays.fill(mat,-1);
            }
        }
        return solve(prices,0,0,0);
    }

    int solve(int[] prices,int i,int baught,int transactions){
        if(i >= n || transactions == 2){
            return 0;
        }

        if(dp[i][baught][transactions] != -1){
            return dp[i][baught][transactions];
        }
        int profit = 0;

        if(baught == 1){
            profit = Math.max(prices[i] + solve(prices,i+1,0,transactions + 1), solve(prices, i + 1, 1,transactions));
        } else {
            profit = Math.max(-prices[i] + solve(prices,i+1,1,transactions),
                    solve(prices,i+1,0,transactions));
        }



        return dp[i][baught][transactions] = profit;
    }
}