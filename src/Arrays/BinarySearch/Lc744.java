package Arrays.BinarySearch;
// remember when exatc answer is to be found we do low <= high and when bc on answer we do low < high anm high = mid and return low
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int idx = bs(letters,target,0,letters.length - 1);
        return idx == -1 ? letters[0] : letters[idx];
    }

    int bs(char[] arr,char target,int low,int high){
        int t = target - 'a';
        int idx = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int mv = arr[mid] - 'a';
            if(mv > t){
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }
}