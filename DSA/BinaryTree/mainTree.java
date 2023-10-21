package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import BST.checkBST;


public class mainTree {
    public static void main(String[] args) {

        // Build a tree..............................
        /*
                       (root)
                node1         node2
                /  \          /
            node3   null   node4   
                            /
                         node5
         */

        TreeNode node1 = new TreeNode(78);
        TreeNode node2 = new TreeNode(267);
        TreeNode node3 = new TreeNode(99);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        TreeNode root = new TreeNode(1, node1, node2);
        node1.left = node3;
        node1.right = null;
        node2.left = node4;
        node2.left.left = node5;

        //System.out.println(levelOrderTraversal.levelorder(root).toString());
        //System.out.println(checkSymetric.isSymmetric(root));

        //System.out.println(leftView._leftView(root).toString());
        //System.out.println(topView._topView(root).toString());   *** incomplete
        
        /*
         
        FlattenBinarytree.flaten(root);
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
         */
        System.out.println(checkBST.isValidBST(root));
    }


}