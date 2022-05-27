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
    public boolean isValidBST(TreeNode root) {
        return this.isValid(root,null,null);
    }
    
    private boolean isValid(TreeNode root,TreeNode minimum,TreeNode maximum)
    {
        if(root == null) return true;
        if(minimum!=null && root.val<=minimum.val || maximum!=null && root.val>=maximum.val) return false;
        else return isValid(root.left,minimum,root)&& isValid(root.right,root,maximum);
    }
    
    
}