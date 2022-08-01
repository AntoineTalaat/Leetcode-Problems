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
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        if(current == null) return null;
        int length = 1;
        while(current.next!=null){
            length++;
            current = current.next;
        }
        
        int midpoint =  (length /2 +1) ;
        current = head;
        for(int i = 1; i< midpoint ; i++) current = current.next;
        
        return current;
    }
}