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
        if (root == null)
            return root;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node found

            // Case 1: No right child
            if (root.right == null)
                return root.left;

            // Case 2: No left child
            else if (root.left == null)
                return root.right;

            // Case 3: Two children
            else {
                root.val = findSuccessor(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    public int findSuccessor(TreeNode root) {
        int successor = -1;
        TreeNode temp = root;
        while (temp != null) {
            successor = temp.val;
            temp = temp.left;
        }
        return successor;
    }
}