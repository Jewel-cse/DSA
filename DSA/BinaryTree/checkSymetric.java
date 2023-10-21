package BinaryTree;

public class checkSymetric {
    public static boolean isSymmetric(TreeNode root) {
        return root == null || symetric(root.left,root.right);
    }
    public static boolean symetric(TreeNode left,TreeNode right){
        if(left == null || right == null)   
            return left == right;
        if(left.val != right.val)
            return false;
        return symetric(left.left,right.right) && symetric(left.right,right.left);
    }
}
