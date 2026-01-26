package dp;

class Solution {
    Map<String, List<Character>> map;
    Map<String,Boolean> memo = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new HashMap<>();
        for (String i : allowed) {
            String temp = "" + i.charAt(0) + i.charAt(1);
            map.computeIfAbsent(temp, (k) -> new ArrayList<>()).add(i.charAt(2));
        }

        return solve(bottom,0,"");
    }

    boolean solve(String curr,int idx,String above){
        String key = curr + Integer.toString(idx) + above;
        if(curr.length() == 1){
            return true;
        }

        if(curr.length() - 1 == idx){
            return solve(above,0,"");
        }

        if(memo.containsKey(key)) return memo.get(key);

        String pair = "" + curr.charAt(idx) + curr.charAt(idx+1);

        if(!map.containsKey(pair)){
            return false;
        }

        for(char ch : map.get(pair)){
            above = above + (char)ch;
            if(solve(curr,idx+1,above)){
                memo.put(key,true);
                return true;
            }
            above = above.substring(0,above.length() - 1);
        }

        memo.put(key,false);
        return false;
    }
}