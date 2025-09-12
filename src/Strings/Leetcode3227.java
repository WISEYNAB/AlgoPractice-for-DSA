package Strings;

import java.util.Set;

class Solution3227 {
    public boolean doesAliceWin(String s) {
        Set<Character> set = Set.of('a','e','i','o','u');
        int vovs = 0;
        for(char i : s.toCharArray()){
            if(set.contains(i)){
                vovs++;
            }
        }

        if(vovs % 2 == 1){
            return true;
        }

        if(vovs == 0){
            return false;
        }

        int si = -1;
        int v = 0;
        int n = s.length();
        for(int i = n - 1;i >= 0;i--){
            if(set.contains(s.charAt(i))){
                if(v == 2){
                    si = i;
                    break;
                }
                ++v;
            }
        }

        return n - si % 2 == 0 ? false : true;

    }
}