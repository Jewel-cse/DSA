package BinaryTree;


public class FlattenBinarytree {
    static TreeNode prev = null;
    public static void flaten(TreeNode node) {
        
        if (node == null)
            return ;
        
        flaten(node.right);
        flaten(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }
}
