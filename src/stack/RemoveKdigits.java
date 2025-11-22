package stack;

class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder res = new StringBuilder();

        int n = num.length();

        for(int i = 0;i < n;i++){
            while(res.length() != 0 && res.charAt(res.length() - 1) > num.charAt(i) && k > 0){
                res.deleteCharAt(res.length() - 1);
                k--;
            }

            res.append(num.charAt(i));
        }

        while(res.length() != 0 && k > 0){
            res.deleteCharAt(res.length() - 1);
            k--;
        }
        while(res.length() != 0 && res.charAt(0) == '0' ){
            res.deleteCharAt(0);
        }
        if(res.length() == 0){
            return "0";
        }

        return res.toString();
    }
}