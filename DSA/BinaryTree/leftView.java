package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class leftView {
     public static ArrayList<Integer> _leftView(TreeNode root){
      ArrayList<Integer> list = new ArrayList<>();
      leftSideview(root,list,0);
      return list;
     

    }
    
    public static void leftSideview(TreeNode node,List<Integer> list,int level){
        if(node == null)    
            return ;
        if(list.size() == level){
            list.add(node.val);
        }
        leftSideview(node.left,list,level+1);      
        leftSideview(node.right,list,level+1);
    }
}
