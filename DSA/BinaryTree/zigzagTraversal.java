package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class zigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) 
            return ans;
        Queue<TreeNode> q = new ArrayDeque<>(Arrays.asList(root));
        int rem = 1;
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
            if (rem % 2 == 1) {
                ans.add(ls);
                rem++;
            }
            else {
                rem++;
                Collections.reverse(ls);
                ans.add(ls);
            }
        }
        return ans;
    }
}
