package Arrays;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        String prev = "";
        for(int i = 0;i < n;i++){
            String curr = words[i];
            if(prev == "" || !isAna(prev,curr)){
                ans.add(curr);
                prev = curr;
            } else {
                continue;
            }
        }

        return ans;
    }

    boolean isAna(String a,String b){
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();

        Arrays.sort(as);
        Arrays.sort(bs);

        return Arrays.equals(as,bs);
    }
}