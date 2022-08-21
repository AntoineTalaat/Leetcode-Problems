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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first=list1;
        ListNode second=list2;
        
        ListNode merged;
        ListNode head;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(first.val<=second.val){
            merged=first;
            first=first.next;
            merged.next=null;
        } else {
            merged=second;
            second=second.next;
            merged.next=null;
        }

        head=merged;
        
        
        
        while(first!=null && second!=null){
            if(first.val<=second.val){
                merged.next=first;
                merged=merged.next;
                first=first.next;
                merged.next=null;
            } else {
                merged.next=second;
                merged=merged.next;
                second=second.next;
                merged.next=null;
            }
        }
        
        if(first==null) merged.next=second;
        else if(second==null) merged.next=first;
        
        return head;
    }
}