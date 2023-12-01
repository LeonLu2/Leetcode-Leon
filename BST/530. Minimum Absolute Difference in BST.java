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
    TreeNode pre;// record the previous node
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
       if(root==null)return 0;
       traversal(root);
       return result;
    }
    public void traversal(TreeNode root){
        if(root==null)return;
        // left
        traversal(root.left);
        // mid
        if(pre!=null){
            result = Math.min(result,root.val-pre.val);
        }
        pre = root;
        // right
        traversal(root.right);
    }
}
