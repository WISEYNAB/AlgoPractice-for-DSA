package dp;

class Solution {
    int n;
    Integer[] dp;
    public int maximumEnergy(int[] energy, int k) {
        n = energy.length;
        int max = Integer.MIN_VALUE;
        dp = new Integer[n+1];
        for(int i = 0;i < n;i++){
            int a = solve(energy,i,k);
            max = Math.max(max,a);
        }

        return max;
    }

    int solve(int[] energy,int i,int k){
        if(i >= n){
            return 0;
        }

        if(dp[i] != null){
            return dp[i];
        }

        return dp[i] = energy[i] + solve(energy,i+k,k);
    }
}