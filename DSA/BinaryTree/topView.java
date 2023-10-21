package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class topView {
    public static List<Integer> _topView(TreeNode node) {
        List<Integer> list1 = new ArrayList<>();
        if (node == null) {
            return list1;
        }
        
        leftside(node.left, list1);
        list1.add(node.val);
        rightside(node.right, list1);

        return list1;  ///
    }

    public static void leftside(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        list.add(node.val);
        leftside(node.left, list);
    }
    public static void rightside(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        list.add(node.val);
        leftside(node.right, list);
    }
}
