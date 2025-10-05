package dp;

class Solution {
    int n;
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new Integer[n+1][n+1];
        return solve(nums,0,n);
    }

    int solve(int[] nums,int i,int prev){
        if(i >= n){
            return 0;
        }

        if(dp[i][prev] != null){
            return dp[i][prev];
        }

        //skip
        int skip = solve(nums,i+1,prev);
        int take = 0;
        //take
        if(prev == n || nums[i] > nums[prev]){
            take = 1 + solve(nums,i+1,i);
        }

        return dp[i][prev] = Math.max(skip,take);
    }
}