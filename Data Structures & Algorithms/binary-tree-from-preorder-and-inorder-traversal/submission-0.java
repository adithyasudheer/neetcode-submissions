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
    int pos=0;
    TreeNode build(int[] preorder, int[] inorder, int l, int r)
    {
        if(l>r)
            return null;
        int i=l;
        for(i=l;i<r;i++)
        {
            if(inorder[i]==preorder[pos])
                break;
        }         
        pos++;
        TreeNode temp=new TreeNode(inorder[i]);
        temp.left=build(preorder,inorder,l,i-1);
        temp.right=build(preorder,inorder,i+1,r);
        return temp;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        return build(preorder,inorder,0,preorder.length-1);
    }
}
