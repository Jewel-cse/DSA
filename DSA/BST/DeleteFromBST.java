package BST;

import BinaryTree.TreeNode;

public class DeleteFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else
                    root = root.left;
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else
                    root = root.right;
            }
        }
        return dummy;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightchild = root.right;
            TreeNode lastRight = lastFinder(root.left);
            lastRight.right = rightchild;
            return root.left;
        }

    }

    public TreeNode lastFinder(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}
