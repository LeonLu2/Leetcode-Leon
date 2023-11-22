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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while(!stack1.isEmpty()) {
            int size = stack1.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();

                if(node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                // right node, push the node and the sum of the path to the stack
                if(node.right != null){
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                // left node, push the node and the sum of the path to the stack
                if(node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }
}
