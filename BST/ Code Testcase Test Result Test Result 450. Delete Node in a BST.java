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
    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root,key);
        return root;
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null; // not found

        if (root.val > key) { // need to go left
            root.left = delete(root.left,key);
        } else if (root.val < key) { // need to go right
            root.right = delete(root.right,key);
        } else { // found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode tmp = root.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            root.val = tmp.val; // replace root with tmp which is the smallest node in right subtree
            root.right = delete(root.right,tmp.val); // then delete tmp from right subtree
        }
        return root;
    }
}
