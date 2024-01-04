package BST;

import java.util.Arrays;

//this is the implementation class of binary search tree:
//insert, search, traverse, delete

public class BST {
    private class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //insert into @@@@@@@@@@@@ binary search tree @@@@@@@@@@@
    
    private Node insert(Node root, int val) {
        if (root == null) {
            return  new Node(val);
            
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }


    //traverse the binary search tree
    
    private void traverse(Node root) {
        if (root == null)
            return;

        traverse(root.left);
        System.out.print(root.val + " ");
        traverse(root.right);
    }
    
    //search a value in bst
    private int search(Node root,int val){
        while(root != null && root.val != val)
            root =  val<root.val?root.left:root.right;
        return (root == null)?-1:root.val;
    }
    //find min and max value in BST
    private static int[] minMax(Node root) {
        Node node = root;
        if (node == null) {
            System.out.println("BST IS EMPTY");
            return new int[] { 0, 0 };
        }
        //go left most node to find minimum
        while (node.left != null) {
            node = node.left;
        }
        int min = node.val;

        //go right most node to find minimum
        Node node2 = root;
        while (node2.right != null) {
            node2 = node2.right;
        }
        int max = node2.val;

        return new int[] { min, max };
    }


    //@@@@@@@@@@@ HEIGHT OF BST @@@@@@@@
    private static int heightOfBST(Node root) {
        if (root == null)
            return 0;
        int lh = heightOfBST(root.left);
        int rh = heightOfBST(root.right);

        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        BST bst = new BST();
        /* for (int i = 0; i < 10; i++) {
        } */
        Node root = null;
        root = bst.insert(root, 30);
        bst.insert(root,51);
        bst.insert(root,10);
        bst.insert(root,41);
        bst.insert(root,15);
        bst.insert(root,11);
        bst.insert(root,61);
       
       
        
        bst.traverse(root);
        System.out.println();
        System.out.println(bst.search(root,51));
        System.out.println(Arrays.toString(minMax(root)));
        System.out.println(heightOfBST(root));
        System.out.println(root.val);
    }
}
