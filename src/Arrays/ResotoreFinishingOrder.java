package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = friends.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> temp = new HashSet();
        int m = order.length;

        for(int i = 0;i < n;i++){
            temp.add(friends[i]);
        }

        for(int i = 0;i < m;i++){
            if(temp.contains(order[i])){
                list.add(order[i]);
                temp.remove(order[i]);
            }
        }

        int[] res = new int[n];

        for(int i = 0;i < n;i++){
            res[i] = list.get(i);
        }

        return res;
    }
}