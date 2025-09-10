package Arrays;

import java.util.*;

class Solution {
    List<Integer> sad = new ArrayList<>();
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        for(int[] i : friendships){
            int a = i[0] - 1;
            int b = i[1] - 1;
            if(!canTalk(languages[a],languages[b])){
                if(!sad.contains(a)){
                    sad.add(a);
                }

                if(!sad.contains(b)){
                    sad.add(b);
                }
            }
        }
        int m = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : sad){
            for(int j : languages[i]){
                map.put(j,map.getOrDefault(j,0) + 1);
                if(map.get(j) > m){
                    m = map.get(j);
                }
            }
        }

        return sad.size() - m;
    }

    boolean canTalk(int[] a,int[] b){
        Set<Integer> set = new HashSet();

        for(int i : a){
            set.add(i);
        }

        for(int i : b){
            if(set.contains(i)){
                return true;
            }
        }

        return false;
    }

}