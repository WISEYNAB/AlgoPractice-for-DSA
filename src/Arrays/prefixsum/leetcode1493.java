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

class Solution1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxlen = 0;

        for(int i = 0;i < n;i++){
            if(nums[i] == 1){
                left[i] = ((i > 0) ? left[i - 1] : 0) + 1;
            } else {
                left[i] = 0;
            }
        }

        for(int i = n - 1;i >= 0;i--){
            if(nums[i] == 1){
                right[i] = ((i < n - 1) ? right[i + 1] : 0) + 1;
            } else {
                right[i] = 0;
            }
        }

        for(int i = 0;i < n;i++){
            int leftc = (i > 0) ? left[i - 1] : 0;
            int rightc = (i < n - 1) ? right[i + 1] : 0;
            maxlen = Math.max(maxlen,leftc + rightc);
        }

        return maxlen == n ? n - 1 : maxlen;
    }
}

//sliding window

class Solution1493sw {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        int right = 0,left = 0,zeros = 0;

        for(;right < n;right++){
            if(nums[right] == 0) zeros++;

            while(zeros > 1){
                if(nums[left] == 0){
                    zeros--;
                }

                left++;
            }

            maxlen = Math.max(maxlen,right - left);
        }


        return maxlen;
    }
}