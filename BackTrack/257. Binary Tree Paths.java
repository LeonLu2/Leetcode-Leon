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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>(); // store final result
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>(); // store current path
        traversal(root, paths, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        paths.add(root.val); // preorder traversal
        // meet a leaf node
        if (root.left == null && root.right == null) {
            // output the path
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1)); // record the last node
            res.add(sb.toString()); // collect the path
            return;
        }
        if (root.left != null) { // left subtree
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// backtracking
        }
        if (root.right != null) { // right subtree
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// backtracking
        }
    }
}
