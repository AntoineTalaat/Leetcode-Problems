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
    public void reorderList(ListNode head) {
        ListNode reversed = this.reverseList(this.duplicateList(head));
        ListNode current = head;
        ListNode dup = this.duplicateList(head);
        while(current!= null && reversed.next != null){
            ListNode removedFirst = current;
            ListNode removedLast = reversed;
            current = current.next;
            reversed = reversed.next;
            /*
                1 2 3 4
                4 3 2 1

                or 1 2 3
                   3 2 1 
                
                when the references are equal on the same page 
                or one move apart then you can stop


                1 2 3 4
                4 3 2 1 
                       f  
                1 2    3 4
                4 3    2 1
                       r

                make 1 point to 4
                1 -> 4 -> 3 2 1
            */

            removedFirst.next = removedLast;   
   
            removedLast.next = current;       
            
        }
        current = head;
        while(dup.next!=null){
            dup= dup.next;
            current=current.next;
        }
        current.next = null;
    }

    private ListNode duplicateList(ListNode head){
        ListNode currentOld = head;
        ListNode currentNew = new ListNode();
        ListNode newHead = currentNew;
        while(currentOld != null){
            currentNew.val = currentOld.val;
            if(currentOld.next != null) currentNew.next = new ListNode();
            currentOld=currentOld.next;
            currentNew=currentNew.next;
        }
        return newHead;
    }       

    private ListNode reverseList(ListNode head) {
    if(head==null) return null;
    if(head.next==null) return head;
    
    ListNode first = null;
    ListNode second = head;
    
    
    while(second!=null){
        ListNode temp = second.next;
        second.next=first;
        first=second;
        second=temp;
    }
    
    return first;
    }
}