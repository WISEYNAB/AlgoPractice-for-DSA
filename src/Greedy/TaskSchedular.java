package Greedy;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        for(char i : tasks){
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        for(char i : map.keySet()){
            pq.add(map.get(i));
        }

        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int freq = pq.poll() - 1;
                if(freq > 0){
                    q.add(new int[]{freq,time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}