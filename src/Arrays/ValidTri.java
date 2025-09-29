package Arrays;
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ways = 0;
        for(int i = 0;i < n - 2;i++){
            for(int j = i + 1;j < n - 1;j++){
                int sum = nums[i] + nums[j];
                int k = bs(j + 1,n - 1,sum,nums);
                ways += (k - j - 1);
            }
        }
        return ways;
    }

    int bs(int low,int high,int target,int[] nums){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}