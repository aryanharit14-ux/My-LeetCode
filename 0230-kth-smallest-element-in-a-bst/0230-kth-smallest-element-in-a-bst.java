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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return inOrder(root);
    }
    int inOrder(TreeNode root){
        if(root==null) return -1;
        int left = inOrder(root.left);
        if(left!=-1) return left;
        if(--k==0) return root.val;
        return inOrder(root.right);
    }
}