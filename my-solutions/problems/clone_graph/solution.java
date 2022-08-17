/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> cloned=new HashMap<>();
    public Node cloneGraph(Node node) {
        Node nw;
        if(node==null) return null;

        nw=new Node(node.val);
        cloned.put(node.val,nw);

        
        for(Node n:node.neighbors)
        {
            Node temp;
            if(!cloned.containsKey(n.val)) {
                temp=cloneGraph(n);
                
            }
            else temp=cloned.get(n.val);
            
            this.connectNodes(nw,temp);
            
        }
        return nw;
    }
    
    private void connectNodes(Node first,Node second){
        first.neighbors.add(second);
    }
}