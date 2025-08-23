package dp;
import java.util.Arrays;

class Solution122 {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n + 1][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(prices,0,0);
    }

    int solve(int[] prices,int i,int baught){
        if(i >= n){
            return 0;
        }

        if(dp[i][baught] != -1){
            return dp[i][baught];
        }

        int profit = 0;
        if(baught == 1){
            profit = Math.max(prices[i] + solve(prices,i+1,0), solve(prices, i + 1, 1));
        } else {
            profit = Math.max(-prices[i] + solve(prices,i+1,1),
                    solve(prices,i+1,0));
        }

        return dp[i][baught] = profit;
    }
}