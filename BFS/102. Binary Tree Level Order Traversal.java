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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();  
        if (root == null) return res;  
        Queue<TreeNode> queue = new LinkedList<>();  
        queue.add(root);  
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();  
            for (int i = 0; i < cnt; i++) {  
                TreeNode node = queue.poll();  
                level.add(node.val);  
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }  
            res.add(level);  
        }  
        return res;
    }
}

// 2nd solution: recursion
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(depth).add(root.val);
        levelHelper(res, root.left, depth + 1);
        levelHelper(res, root.right, depth + 1);
    }
}
