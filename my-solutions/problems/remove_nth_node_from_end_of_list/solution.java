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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode second= head;
        ListNode third=head;
        
        for(int i=0;i<n-1;i++) first = first.next;
        
        Boolean secondPassed = false;
        while(first.next!=null){
            first=first.next;
            second=second.next;
            if(secondPassed) third=third.next;
            secondPassed=true;
        }
        
        
        if(second==head)
            head=second.next;
        else
            third.next=second.next;
        
        return head;
    }
}