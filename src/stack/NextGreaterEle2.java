package stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[];

        int j = 0;
        for(int i = 0;i < 2 * n;i++){
            int index = i % n;
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                ans[j++] = nums[i];
            }
        }
    }
}