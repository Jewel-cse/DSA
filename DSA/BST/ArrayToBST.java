package BST;


public class ArrayToBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }


    //#####################################################
    //function  calling from main
    public  TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return buildBST(nums, 0, nums.length - 1);
    }

    //build the BST
    public  TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }
    //print the bst inorder traversal(sorted print hobe)
    public static void printBST(TreeNode root) {
        if (root != null) {
            printBST(root.left);
            System.out.print(root.val + " ");
            printBST(root.right);
        }
    }
    
    
    public static void main(String[] args) {
        ArrayToBST arrbst = new ArrayToBST();
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode root = arrbst.sortedArrayToBST(nums);
        printBST(root);
    }
}
