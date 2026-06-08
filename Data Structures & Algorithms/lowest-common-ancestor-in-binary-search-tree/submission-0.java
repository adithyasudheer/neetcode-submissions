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
    public void getPath(TreeNode root,TreeNode p,List<TreeNode>l)
    {
        if(root==null)
            return;
        if(l.size()>0)
        {
            l.add(root);
            return;
        }
        if(root.val==p.val)
        {
            l.add(root);
            return;
        }
        getPath(root.right,p,l);
        if(l.size()>0)
        {
            l.add(root);
            return;
        }
        getPath(root.left,p,l);
        if(l.size()>0)
        {
            l.add(root);
            return;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        List<TreeNode>lp=new ArrayList<>();
        getPath(root,p,lp);
        List<TreeNode>lq=new ArrayList<>();
        getPath(root,q,lq);    
        Collections.reverse(lp);
        Collections.reverse(lq);
        int i=0;
        TreeNode res=root;
        for(i=0;i<lp.size() && i<lq.size();i++)
        {
            if(lp.get(i).val==lq.get(i).val)
            {
                res=lp.get(i);
            }
            else
                break;
        }
        return res;
    }
}
