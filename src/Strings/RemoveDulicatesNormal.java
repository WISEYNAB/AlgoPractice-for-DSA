package Strings;

class Solution {
    public String removeDuplicateLetters(String s) {
        String sb = "";
        int n = s.length();
        for(int i = 0;i < n;i++){
            int idx = sb.indexOf(s.charAt(i));
            if(idx == -1){
                sb += s.charAt(i);
            }
        }

        return sb;
    }
}