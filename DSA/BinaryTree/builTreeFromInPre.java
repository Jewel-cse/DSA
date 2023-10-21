package BinaryTree;

import java.util.HashMap;

public class builTreeFromInPre {
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        if (inorder == null || preorder == null || inorder.length != preorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeInandPost(inorder, 0, inorder.length, preorder, 0, preorder.length-1, map);
    }

    public TreeNode buildTreeInandPost(int[] in, int instart, int inend, int[] pre, int prestart, int preend,
            HashMap<Integer, Integer> map) {
        if (prestart > preend || instart > inend)
            return null;
        TreeNode root = new TreeNode(pre[prestart]);

        int rootPos = map.get(pre[prestart]);
        int leftPos = rootPos - instart;

        root.left = buildTreeInandPost(in, instart, rootPos - 1, pre, prestart+1, prestart + leftPos - 1, map);
        
        root.right = buildTreeInandPost(in, rootPos + 1, inend, pre, prestart +1 + leftPos, preend, map);
        return root;
        
    }
}
