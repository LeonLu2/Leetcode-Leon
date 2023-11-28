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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // use map to store the index of inorder array
            map.put(inorder[i], i);
        }

        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // the range of inorder and postorder is [begin, end)
        if (inBegin >= inEnd || postBegin >= postEnd) {  // stop condition when the range is empty
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // find the index of root in inorder array (postEnd - 1)
        TreeNode root = new TreeNode(inorder[rootIndex]);  // construct the root node
        int lenOfLeft = rootIndex - inBegin;  // save the length of left subtree for later use
        root.left = findNode(inorder, inBegin, rootIndex,
                            postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                            postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }
}
