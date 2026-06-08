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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        if(root==null)
            return new ArrayList<>();
        Deque<TreeNode>dq=new LinkedList<>();    
        dq.offerLast(root);
        dq.offerLast(null);
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        while(!dq.isEmpty())
        {
            TreeNode t=dq.pollFirst();
            if(t==null)
            {
                if(!temp.isEmpty())
                {
                    res.add(temp);
                    temp=new ArrayList<>();
                }
                if(!dq.isEmpty())
                    dq.offerLast(null);
            }
            else
            {
                temp.add(t.val);
                if(t.left!=null)
                    dq.offerLast(t.left);
                if(t.right!=null)
                    dq.offerLast(t.right);                
            }
        }
        return res;
    }
}
