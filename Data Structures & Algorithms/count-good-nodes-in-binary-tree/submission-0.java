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
    int count=0;
    void helper(TreeNode root,int maxval)
    {
        if(root==null)
            return;
        if(root.val>=maxval)
            count++;
        helper(root.left,Math.max(maxval,root.val));
        helper(root.right,Math.max(maxval,root.val));
    }
    public int goodNodes(TreeNode root) {
        helper(root,root.val);
        return count;
    }
}
