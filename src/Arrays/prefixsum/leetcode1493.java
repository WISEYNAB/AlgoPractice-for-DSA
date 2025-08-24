package Arrays.prefixsum;

import java.util.ArrayList;
import java.util.List;
//bruteforce
class Solution {
    int maxo;
    public int longestSubarray(int[] nums) {
        maxo = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            dandt(temp, i);
        }
        return maxo;
    }

    void dandt(List<Integer> temp,int i){
        int cont = 0;
        temp.remove(i);
        for(int j = 0;j < temp.size();j++){
            if(temp.get(j) == 1){
                cont++;
                maxo = Math.max(maxo,cont);
            } else {
                cont = 0;
            }
        }
    }
}

//optimal prefix sum