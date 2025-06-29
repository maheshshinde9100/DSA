package tree;

import java.util.Stack;

public class DFS_Tree {
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    Stack<TreeNode> stack = new Stack<>();
    void preorder(TreeNode root){
        if(root==null) return;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            System.out.println(current.data);
            if(current.right!=null){
                stack.push(current.right);
            }
            if(current.left!=null){
                stack.push(current.left);
            }
            current = current.left;
        }
    }

    void inorder(TreeNode root){
        if(root==null) return;
        TreeNode current = root;
        while(!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }
    Stack<TreeNode> stack2 = new Stack<>();
    void postorder(TreeNode root){
        if(root==null) return;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            if(current.left!=null){
                stack.push(current.left);
            }
            if(current.right!=null){
                stack.push(current.right);
            }
            stack2.push(current);
            current = current.left;
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().data);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);  //                                 100
        root.left = new TreeNode(5);        //                            5           10
        root.right = new TreeNode(10);      //                        60     20   30       80
        root.left.left = new TreeNode(60);  //
        root.left.right = new TreeNode(20); //
        root.right.left = new TreeNode(30); //
        root.right.right = new TreeNode(80); //

        DFS_Tree obj = new DFS_Tree();
//        obj.preorder(root);  //preorder (VLR): 100,5,60,20,10,30,80
//        obj.inorder(root); //inorder (LVR): 60,5,20,100,30,10,80
        obj.postorder(root); //postorder (LRV): 60,20,5,30,80,10,100
    }
}
