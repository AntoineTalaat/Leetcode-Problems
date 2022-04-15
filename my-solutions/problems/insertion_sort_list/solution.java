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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode previous=head;
        while(previous.next!=null){
            ListNode current=previous.next;
            ListNode forward=current.next;
            
            //deattach
            previous.next=forward;
            
            //find place
            ListNode temp=head;
            ListNode tempN=head.next;
            if(current.val<temp.val) //head
            {
                current.next=head;
                head=current;
            } else {
                while(tempN!=forward && tempN != null && current.val>=tempN.val){
                    temp=tempN;
                    tempN=tempN.next;
                }
                current.next=tempN;
                temp.next=current;
            }
            
            if(previous.next!=forward) previous= previous.next;
            
        }

        return head;
    }
}

