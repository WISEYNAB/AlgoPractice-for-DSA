package Strings;

class Solution {
    Set<Character> vovels = Set.of('a','e','i','o','u');
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String,String> masked = new HashMap<>();
        Map<String,String> lower = new HashMap<>();
        Set<String> exact = new HashSet<>();

        //pre
        for(String i : wordlist){
            exact.add(i);
            String l = i.toLowerCase();
            lower.putIfAbsent(l,i);
            String m = mask(i);
            masked.putIfAbsent(m,i);
        }

        String[] ans = new String[queries.length];

        for(int i = 0;i < queries.length;i++){
            String word = queries[i];
            if(exact.contains(word)){
                ans[i] = word;
            } else {
                if(lower.containsKey(word.toLowerCase())){
                    ans[i] = lower.get(word.toLowerCase());
                } else {
                    String mas = mask(word);
                    ans[i] = masked.getOrDefault(mas,"");
                }
            }
        }

        return ans;
    }

    String mask(String s){
        StringBuilder j = new StringBuilder(s.toLowerCase());
        int n = j.length();
        for(int i = 0;i < n;i++){
            char a = j.charAt(i);
            if(vovels.contains(a)){
                j.setCharAt(i,'*');
            }
        }

        return j.toString();
    }
}