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
    public List<Integer> rightSideView(TreeNode root) 
    {
        if(root==null)
            return new ArrayList<>();
        ArrayDeque<TreeNode>dq=new ArrayDeque<>();
        List<Integer>res=new ArrayList<>();
        dq.push(root);
        while(!dq.isEmpty())
        {
            int sz=dq.size();
            TreeNode value=dq.peekLast();
            res.add(value.val);
            while(sz>0)
            {
                TreeNode node=dq.pollFirst();
                if(node.left!=null)
                    dq.offerLast(node.left);
                if(node.right!=null)
                    dq.offerLast(node.right);
                sz--;
            }
        }
        return res;
    }
}
