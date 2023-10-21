package BinaryTree;

import Strivers.LinkedList.ListNode;

class diameterOfBT {
   
    public int diameterOfBinaryTree(TreeNode root) {
        int[] mx = new int[1];
        findMax(root, mx);
        return mx[0];
    }

    public int findMax(TreeNode node, int[] mx) {
        if (node == null)
            return 0;

        int lh = findMax(node.left,mx);
        int rh = findMax(node.right, mx);

        mx[0] = Math.max(lh + rh, mx[0]);

        return 1 + Math.max(lh, rh);
    }

    
}