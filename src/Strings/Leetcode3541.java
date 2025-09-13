package Strings;

import java.util.Set;

class Solution3541 {
    public int maxFreqSum(String s) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int[] freq = new int[26];
        int vovf = 0;
        int cons = 0;

        for (char i : s.toCharArray()) {
            freq[i - 'a']++;
            int f = freq[i - 'a'];
            if (set.contains(i)) {
                vovf = Math.max(vovf, f);
            } else {
                cons = Math.max(cons, f);
            }
        }
        return vovf + cons;
    }
}
