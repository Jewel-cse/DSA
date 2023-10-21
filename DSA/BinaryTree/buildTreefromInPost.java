package BinaryTree;

import java.util.HashMap;

import Strivers.Stack_queue.Strivers.Stack.pair;

class buildTreefromInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeInandPost(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    public TreeNode buildTreeInandPost(int[] in, int instart, int inend, int[] post, int poststart, int postend,
            HashMap<Integer, Integer> map) {
        if (poststart > postend || instart > inend)
            return null;
        TreeNode root = new TreeNode(post[postend]);

        int rootPos = map.get(post[postend]);
        int leftPos = rootPos - instart;

        root.left = buildTreeInandPost(in, instart, rootPos - 1, post, poststart, poststart + leftPos - 1, map);
        
        root.right = buildTreeInandPost(in, rootPos + 1, inend, post, poststart + leftPos, postend - 1, map);
        return root;
    }
}