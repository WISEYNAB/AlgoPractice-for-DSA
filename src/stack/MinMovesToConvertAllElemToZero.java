package stack;

class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int opr = 0;
        for(int i = 0;i < n;i++){
            while(!stack.isEmpty() && stack.peek() > nums[i]){
                stack.pop();
            }

            if(nums[i] == 0) continue;

            if(stack.isEmpty() || nums[i] > stack.peek()){
                opr++;
                stack.push(nums[i]);
            }
        }
        return opr;
    }
}