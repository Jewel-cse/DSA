package BST;

import BinaryTree.TreeNode;

public class checkBST {
    public static boolean isValidBST(TreeNode root) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        return validate(root, low, high);
    }

    public static boolean validate(TreeNode root, int low, int high) {
        if (root == null ) {
            return true;
        }
        if (root.val >= high || root.val <= low) {    // low < val <high na thakle false
            return false;
        }
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}
