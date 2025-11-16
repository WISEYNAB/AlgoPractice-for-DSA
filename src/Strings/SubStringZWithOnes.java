package Strings;

class Solution {
    public int numSub(String s) {
        int ans = 0;
        int ones = 0;
        int m = (int)Math.pow(10,9) + 7;
        for(char i : s.toCharArray()){
            if(i == '0'){
                ones = 0;
            } else {
                ones++;
                ans = (ones + ans) % m;
            }
        }

        return ans % m;
    }
}