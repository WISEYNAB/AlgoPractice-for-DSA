package linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        while(head != null && set.contains(head.val)){
            head = head.next;
        }
        if(head == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            if(set.contains(curr.val)){
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}