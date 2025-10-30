package Arrays;

class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] prefix = new int[n];

        for(int i = 0;i < n;i++){
            prefix[i] = target[i] - nums[i];
        }

        int prev = prefix[0];
        long opr = Math.abs(prefix[0]);

        for(int i = 1;i < n;i++){
            int curr = prefix[i];

            if(!opp(curr, prev)){
                if(Math.abs(curr) > Math.abs(prev)){
                    opr += Math.abs(curr) - Math.abs(prev);
                }
            } else {
                opr += Math.abs(curr);
            }

            prev = curr;
        }

        return opr;
    }

    boolean opp(int a,int b){
        return a > 0 && b < 0 || a < 0 && b > 0;
    }
}