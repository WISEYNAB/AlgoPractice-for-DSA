package Strings;

class Solution {
    public boolean hasSameDigits(String s) {
        String a = s;
        while(a.length() >= 2){
            int n = a.length();
            if(n == 2){
                char q = a.charAt(n - 1);
                char t = a.charAt(n - 2);
                if(q == t) return true;
            }
            a = operate(a);
        }
        return false;
    }

    String operate(String s){
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 1;i < n;i++){
            int a = (s.charAt(i) - '0' + s.charAt(i - 1) - '0') % 10;
            char t = (char)(a + '0');
            sb.append(t);
        }
        return sb.toString();
    }
}