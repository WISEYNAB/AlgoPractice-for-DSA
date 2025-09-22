package HashMap;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0) + 1);
            max = Math.max(max,map.get(i));
        }
        int ans = 0;
        for(int i : map.keySet()){
            int f = map.get(i);
            ans = f == max ? ans + f : ans;
        }

        return ans;
    }
}