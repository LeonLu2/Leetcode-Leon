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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // use map to store the index of inorder array
            map.put(inorder[i], i);
        }

        return findNode(preorder, 0, preorder.length, inorder,  0, inorder.length);
    }

    public TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        // the range of preorder and inorder is [begin, end)
        if (preBegin >= preEnd || inBegin >= inEnd) {  // stop condition when the range is empty
            return null;
        }
        int rootIndex = map.get(preorder[preBegin]);  // find the index of root in inorder array
        TreeNode root = new TreeNode(inorder[rootIndex]);  // construct the root node
        int lenOfLeft = rootIndex - inBegin;  // save the length of left subtree for later use
        root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1,
                            inorder, inBegin, rootIndex);
        root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd,
                            inorder, rootIndex + 1, inEnd);

        return root;
    }
}