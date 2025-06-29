package tree;

import java.util.Scanner;
import java.util.Stack;

public class IterativeApproaches {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private TreeNode root = null;  // root is now a class-level field
    Scanner sc = new Scanner(System.in);

    public void create() {
        System.out.print("Enter the element to insert :> ");
        int x = sc.nextInt();
        TreeNode temp = new TreeNode(x);
        if (root == null) {
            root = temp;
        } else {
            insert(root, temp);
        }
    }

    public void insert(TreeNode current, TreeNode newNode) {
        if (newNode.data < current.data) {
            if (current.left == null) {
                current.left = newNode;
            } else {
                insert(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
            } else {
                insert(current.right, newNode);
            }
        }
    }

    public void display() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        System.out.println("Choose traversal :>\n1. Preorder\n2. Inorder\n3. Postorder");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.print("Preorder traversal: ");
                preorder(root);
                break;
            case 2:
                System.out.print("Inorder traversal: ");
                inorder(root);
                break;
            case 3:
                System.out.print("Postorder traversal: ");
                postorder(root);
                break;
            default:
                System.out.println("Invalid choice");
        }
        System.out.println();
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.data + " ");
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }

    public void postorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode current = s1.pop();
            s2.push(current);
            if (current.left != null) s1.push(current.left);
            if (current.right != null) s1.push(current.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(key<root.data){
            root.left=deleteNode(root.left,key);
        }else if(key> root.data){
            root.right = deleteNode(root.right,key);
        }else{
            //equal key=root.data
            if(root.left==null && root.right==null) return null; //leaf node
            else if(root.left==null) return root.right;         //have one right child
            else if(root.right==null) return root.left;     //have one left child
            else{                                           //have two child
                //inorder successor
                TreeNode temp = root.right;
                while(temp.left!=null){
                    temp = temp.left;
                }

                root.data = temp.data;
                root.right = deleteNode(root.right,temp.data);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        IterativeApproaches obj = new IterativeApproaches();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nEnter choice :>\n1. Insert\n2. Display\n3. Delete\n4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    obj.create();
                    break;
                case 2:
                    obj.display();
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    int val = sc.nextInt();
                    obj.root = obj.deleteNode(obj.root, val); // update root in case root is deleted
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);
    }
}
