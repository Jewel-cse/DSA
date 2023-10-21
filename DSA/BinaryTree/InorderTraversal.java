package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inOrder(root,lst);

        return lst;
          
    }
    public static void inOrder(TreeNode root,List<Integer> lst){
        if(root == null)    return ;
        
        inOrder(root.left,lst);
        lst.add(root.val);
        inOrder(root.right,lst);

    }
}
