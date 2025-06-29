package tree;

import java.util.ArrayDeque;
import java.util.Queue;

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
    Queue<TreeNode> q = new ArrayDeque<>();
    void display(TreeNode root) {
        if(root==null) return;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            System.out.println(current.data);

            if(current.left!=null){
                q.offer(current.left);
            }
            if(current.right!=null){
                q.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);  //                                 100
        root.left = new TreeNode(5);        //                            5           10
        root.right = new TreeNode(10);      //                        60     20   30       80
        root.left.left = new TreeNode(60);  //
        root.left.right = new TreeNode(20); //  level order traversal : 100,5,10,60,20,30,80
        root.right.left = new TreeNode(30); //
        root.right.right = new TreeNode(80); //

        LevelOrder order = new LevelOrder();
        order.display(root);
    }
}
