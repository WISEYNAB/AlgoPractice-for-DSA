package dp;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        solve(nums,0,new ArrayList<Integer>());
        return result;
    }

    void solve(int[] nums,int i,List<Integer> temp){
        if(i >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        solve(nums,i + 1,temp);
        temp.remove(temp.size() - 1);
        solve(nums,i+1,temp);
    }

}