package BST;

import BinaryTree.TreeNode;

public class insertInBST {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode curNode = root;
        while(true){
            if(val>curNode.val){
                if(curNode.right == null){
                    curNode.right = new TreeNode(val);
                    break;
                }else{
                    curNode = curNode.right;
                }
            }
            else{
                if(curNode.left == null){
                    curNode.left = new TreeNode(val);
                    break;
                }
                else{
                    curNode = curNode.left;
                }
            }
        }
        return root;
    }
}
