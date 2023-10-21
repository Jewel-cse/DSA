package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {
    public static List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) 
            return ans;
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
        while (!q.isEmpty()) {
            List<Integer> ls = new ArrayList<>();
            for (int i = q.size(); i > 0; i--) {
                TreeNode t = q.poll();
                ls.add(t.val);
                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);
            }
            ans.add(ls);
        }
        return ans;
    }
}
