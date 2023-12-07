/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // postorder
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) { // p or q not found
            return null;
        }else if(left == null && right != null) { // if found one node in right subtree
            return right;
        }else if(left != null && right == null) { // if found one node in left subtree
            return left;
        }else { // if found both nodes in left and right subtree
            return root;
        }
    }
}
