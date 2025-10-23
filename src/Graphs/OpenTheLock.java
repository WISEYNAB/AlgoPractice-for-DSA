package Graphs;
//BFS

class Solution {
    Queue<String> q;
    Set<String> set;
    public int openLock(String[] deadends, String target) {
        q = new LinkedList<>();
        set = new HashSet<>();
        for(String i : deadends){
            set.add(i);
        }
        if(set.contains("0000")){
            return -1;
        }
        int level = 0;
        q.offer("0000");
        set.add("0000");
        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                String curr = q.poll();
                if(curr.equals(target)){
                    return level;
                }

                fill(curr);
                size--;
            }
            level++;
        }

        return -1;
    }

    void fill(String curr){
        StringBuilder sb = new StringBuilder(curr);
        for(int i = 0;i < 4;i++){
            char a = sb.charAt(i);
            char inc = a == '9' ? '0' : (char)(((a - '0') + 1) + '0');
            char dec = a == '0' ? '9' : (char)(((a - '0') - 1) + '0');
            sb.setCharAt(i,inc);
            if(!set.contains(sb.toString())){
                q.offer(sb.toString());
                set.add(sb.toString());
            }
            sb.setCharAt(i,curr.charAt(i));
            sb.setCharAt(i,dec);
            if(!set.contains(sb.toString())){
                q.offer(sb.toString());
                set.add(sb.toString());
            }
            sb.setCharAt(i,curr.charAt(i));
        }
    }
}