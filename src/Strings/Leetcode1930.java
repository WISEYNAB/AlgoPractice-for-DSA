package Strings;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        Set<Character> set = new HashSet();
        for(char i : s.toCharArray()){
            set.add(i);
        }

        for(char i : set){
            int first = s.indexOf(i);
            int last = s.lastIndexOf(i);
            if(first < last + 1){
                Set<Character> temp = new HashSet<>();
                for(int j = first + 1;j <= last - 1;j++){
                    temp.add(s.charAt(j));
                }

                ans += temp.size();
            }
        }

        return ans;
    }
}