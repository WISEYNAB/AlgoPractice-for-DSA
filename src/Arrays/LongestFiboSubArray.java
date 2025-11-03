package Arrays;

class Solution {
    public int longestSubarray(int[] nums) {
        int maxLen = 0;
        int count = 2;
        int n = nums.length;
        if(n < 2){
            return n;
        }
        int prev1 = nums[0];
        int prev2 = nums[1];
        for(int i = 2;i < n;i++){
            if(prev1 + prev2 == nums[i]){
                count++;
            } else {
                count = 2;
            }
            prev1 = prev2;
            prev2 = nums[i];
            maxLen = Math.max(maxLen,count);
        }

        return maxLen;
    }
}