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
        List<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode>dq=new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty())
        {            
            int sz=dq.size();
            
            for(int i=0;i<sz;i++)
            {
                TreeNode t=dq.poll();
                if(i==sz-1)
                    res.add(t.val);
                if(t!=null && t.left!=null)
                    dq.offer(t.left);
                if(t!=null && t.right!=null)
                    dq.offer(t.right);
            }
        }
        return res;
    }
}
