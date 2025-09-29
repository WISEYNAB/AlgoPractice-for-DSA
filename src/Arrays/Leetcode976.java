package Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for(int i = 0;i <= nums.length - 3;i++){
            int a = nums[i];
            int b = nums[i+1];
            int c = nums[i+2];
            if(canForm(a,b,c)){
                max = Math.max(max,a+b+c);
            }
        }
        return max;
    }

    boolean canForm(int a,int b,int c){
        if(a + b <= c ||
                b + c <= a ||
                a + c <= b){
            return false;
        }

        return true;
    }
}