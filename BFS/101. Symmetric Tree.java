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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode u = root.left;
        TreeNode v = root.right;
        if(root == null || (u == null && v == null)) return true;
        q.add(u);
        q.add(v);
        while(!q.isEmpty()){
            u = q.poll();
            v = q.poll();
            if(u == null && v == null) continue;
            if(u == null || v == null || u.val != v.val) return false;
            q.add(u.left);
            q.add(v.right);
            q.add(u.right);
            q.add(v.left);
        }
        return true;
    }
}
