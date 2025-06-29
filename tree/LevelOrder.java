package tree;

public class LevelOrder {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    TreeNode root = null;

    void display(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(60);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(80);

        LevelOrder order = new LevelOrder();
        order.display(root);
    }
}
