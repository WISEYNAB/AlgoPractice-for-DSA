package Arrays;
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int curr = 1;
        int prev = 0;
        int n = nums.size();
        for(int i = 1;i < n;i++){
            if(nums.get(i) > nums.get(i-1)){
                curr++;
            } else {
                prev = curr;
                curr = 1;
            }

            if(curr >= 2 * k){
                return true;
            }
            int min = Math.min(curr,prev);
            if(min >= k){
                return true;
            }
        }
        return false;
    }
}