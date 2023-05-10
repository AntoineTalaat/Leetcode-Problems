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
    public boolean isPalindrome(ListNode head) {
        ListNode currentOld = head;
        ListNode newHead = new ListNode();
        ListNode currentNew = newHead;
        while(currentOld!=null){
            currentNew.val = currentOld.val;
            ListNode newNextNode = null;

            if(currentOld.next!=null)
                newNextNode = new ListNode();
            currentNew.next = newNextNode;
            
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }

        // at this point the ll is copied
        ListNode first = null;
        ListNode second = newHead;

        while(second!=null){
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }


    
        // at this point the ll is reversed
        

        currentNew = first;
        currentOld = head;

        // ListNode currentOld2= currentOld;
        // while(currentOld2!= null){
        //     // System.out.println(currentOld2.val);
        //     currentOld2 = currentOld2.next;
        // }
        // System.out.println("separator");
        // ListNode currentNew2= currentNew;
        // while(currentNew2!= null){
        //     // System.out.println(currentNew2.val);
        //     currentNew2 = currentNew2.next;
        // }
        // System.out.println("done");



        while ( currentOld != null ){
            // System.out.println(currentNew.val + " " + currentOld.val);
            if(currentNew.val!=currentOld.val)
                return false;
            // System.out.println("next node is null ?" + currentOld.next == null);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }
        return true;
    }
}