package Graphs;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(s);
        String smallest = s;
        visited.add(s);
        while(!q.isEmpty()){
            String curr = q.poll();
            if(curr.compareTo(smallest) < 0){
                smallest = curr;
            }

            //add a to all odd i
            StringBuilder sb = new StringBuilder(curr);
            int n = curr.length();
            for(int i = 1;i < n;i += 2){
                char h = sb.charAt(i);
                char opp = (char)(((h - '0' + a) % 10) + '0');
                sb.setCharAt(i,opp);
            }
            if(!visited.contains(sb.toString())){
                q.offer(sb.toString());
                visited.add(sb.toString());
            }

            //rotate opp
            String rot = rotate(curr,b);
            if(!visited.contains(rot)){
                q.offer(rot);
                visited.add(rot);
            }
        }

        return smallest;
    }

    String rotate(String curr,int b){
        StringBuilder sb = new StringBuilder(curr);
        int n = curr.length();
        for(int i = 0;i < n;i++){
            int j = (i + b) % n;
            sb.setCharAt(j,curr.charAt(i));
        }
        return sb.toString();
    }
}