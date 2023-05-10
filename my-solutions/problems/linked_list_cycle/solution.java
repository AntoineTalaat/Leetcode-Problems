/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Boolean> map= new HashMap<>();
        if(head == null) return false;
        ListNode current = head;
        while(current!=null){
            map.put(current,true);
            current = current.next;
            if(map.getOrDefault(current,false) == true)
                return true;

        }
        
        return false;
    }
}