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
    public List<Integer> postorderTraversal(TreeNode root)
    {
        Stack<TreeNode>stl=new Stack<>();
        Stack<TreeNode>str=new Stack<>();    
        List<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        stl.push(root);
        while(!stl.isEmpty())
        {
            TreeNode temp=stl.pop();
            if(temp.left!=null)
                stl.push(temp.left);
            if(temp.right!=null)
                stl.push(temp.right);
            str.push(temp);
        }
        while(!str.isEmpty())
        {
            TreeNode t=str.pop();
            res.add(t.val);
        }
        return res;
    }
}