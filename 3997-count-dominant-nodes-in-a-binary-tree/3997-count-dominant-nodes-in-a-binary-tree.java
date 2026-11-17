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
    class Pair{
        int max;
        int count;
        Pair(int max,int count){
            this.max=max;
            this.count=count;
        }
    }
    public int countDominantNodes(TreeNode root) {
        return dfs(root).count;
    }
    private Pair dfs(TreeNode root){
        if(root==null) return new Pair(Integer.MIN_VALUE,0);
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int max = Math.max(root.val,Math.max(left.max,right.max));
        int count = left.count + right.count;
        if(root.val==max) count++;
        return new Pair(max,count);
    }
}