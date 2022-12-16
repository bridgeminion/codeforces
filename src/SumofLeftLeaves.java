import javax.swing.tree.TreeNode;

public class SumofLeftLeaves {

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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null){
            return 0;
        }
        return s (root, false);
    }

    public int s (TreeNode root, boolean left){
        if (root.left == null && root.right == null){
            if (left){
                return root.val;
            }
            return 0;
        }
        int ans = 0;
        if (root.left != null){
            ans += s (root.left, true);
        }
        if (root.right != null){
            ans += s (root.right, false);
        }
        return ans;
    }
}
