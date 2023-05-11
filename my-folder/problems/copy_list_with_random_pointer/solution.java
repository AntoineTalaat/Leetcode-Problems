/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(head.next == null){
            Node x = new Node(head.val);
            x.random = (head.random == null)? null: x;
       }

        HashMap<Node,Node> oldtoNew = new HashMap<>();    
        Node newHead = new Node(head.val);
        oldtoNew.put(head, newHead);
        Node currentOld = head;
        Node currentNew = newHead;
        while(currentOld!=null){
            if(currentOld.random != null){
                if(oldtoNew.getOrDefault(currentOld.random,null)==null){
                    currentNew.random = new Node(currentOld.random.val);
                    oldtoNew.put(currentOld.random,currentNew.random);
                } else 
                    currentNew.random = oldtoNew.getOrDefault(currentOld.random,null);

            } else 
                currentNew.random = null;

            if(currentOld.next != null){
                // if it not already created and placed in map add it
                if(oldtoNew.getOrDefault(currentOld.next,null)==null){
                    currentNew.next = new Node(currentOld.next.val);
                    oldtoNew.put(currentOld.next,currentNew.next);
                }
                else // it is there, you can link to it
                    currentNew.next = oldtoNew.getOrDefault(currentOld.next,null);
            }
            currentOld = currentOld.next;
            currentNew = currentNew.next; 
        }          
    return newHead;
    }
}
