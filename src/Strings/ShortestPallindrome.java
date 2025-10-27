package Strings;

class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder ans = new StringBuilder(s);
        String rev = ans.reverse().toString();

        int n = s.length();

        for(int i = 0;i < n;i++){
            if(s.substring(0,n - i).equals(rev.substring(i))){
                s = rev.substring(0,i) + s;
                break;
            }
        }
        return s;
    }
}