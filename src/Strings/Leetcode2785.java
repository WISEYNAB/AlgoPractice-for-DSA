package Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class Solution {
    public String sortVowels(String s) {
        List<Integer> indices = new ArrayList<>();
        List<Character> vovs = new ArrayList<>();
        Set<Character> set = Set.of('a','e','i','o','u');
        int n = s.length();

        for(int i = 0;i < n;i++){
            char a = s.charAt(i);
            if(set.contains(Character.toLowerCase(a))){
                indices.add(i);
                vovs.add(a);
            }
        }

        Collections.sort(vovs);
        StringBuilder ans = new StringBuilder(s);

        int m = vovs.size();
        for(int i = 0;i < m;i++){
            ans.setCharAt(indices.get(i),vovs.get(i));
        }

        for(int i = 0;i < n;i++){
            char a = s.charAt(i);
            if(!set.contains(Character.toLowerCase(a))){
                ans.setCharAt(i,a);
            }
        }

        return ans.toString();
    }
}