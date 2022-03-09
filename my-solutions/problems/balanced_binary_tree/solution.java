/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(Solution.getHeight(root.right)-Solution.getHeight(root.left))>1)
            return false;
        else if(isBalanced(root.right) && isBalanced(root.left))
            return true;       
        else return false;
    }
    
    public static int getHeight(TreeNode node){
        if(node==null)  return 0;
        int rightHeight=0;
        int leftHeight=0;
        if(node.right!=null)
            rightHeight=getHeight(node.right);  
        if(node.left!=null)
            leftHeight=getHeight(node.left);
        return (Math.max(rightHeight,leftHeight)+1);
        
    }
    
    
    
}