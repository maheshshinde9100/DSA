package tree;

public class SymmetryTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    TreeNode root = null;

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }

        boolean leftSubtreeCheck = isMirror(t1.left, t2.right);
        boolean rightSubtreeCheck = isMirror(t1.right, t2.left);
        return leftSubtreeCheck && rightSubtreeCheck;
    }

    public static void main(String[] args) {
        SymmetryTree tree = new SymmetryTree();

        // Construct a symmetric tree
        //        1
        //      /   \
        //     2     2
        //    / \   / \
        //   3   4 4   3

        tree.root = tree.new TreeNode(1);
        tree.root.left = tree.new TreeNode(2);
        tree.root.right = tree.new TreeNode(2);

        tree.root.left.left = tree.new TreeNode(3);
        tree.root.left.right = tree.new TreeNode(4);

        tree.root.right.left = tree.new TreeNode(4);
        tree.root.right.right = tree.new TreeNode(3);

        System.out.println("Is the tree symmetric? " + tree.isSymmetric(tree.root)); // Should print true
    }
}
