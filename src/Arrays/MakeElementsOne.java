package Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int ones = 0;
        int n = nums.length;
        for(int i : nums){
            if(i == 1) ones++;
        }

        if(ones != 0) return n - ones;

        int minL = Integer.MAX_VALUE;

        for(int l = 0;l < n;l++){
            int curr_gcd = 0;
            for(int r = l;r < n;r++){
                curr_gcd = gcd(curr_gcd,nums[r]);
                if(curr_gcd == 1){
                    minL = Math.min(minL,r - l + 1);
                    break;
                }
            }
        }

        return minL == Integer.MAX_VALUE ? -1 : (minL - 1) + n - 1;
    }

    int gcd(int a,int b){
        if(b > a) return gcd(b,a);
        if(b == 0) return a;
        return gcd(b,a % b);
    }
}