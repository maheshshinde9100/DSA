package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Tree{
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    private TreeNode root;
    Scanner sc = new Scanner(System.in);

    public void create(){
        System.out.println("Enter element :> ");
        int x = sc.nextInt();
        TreeNode temp = new TreeNode(x);
        if(root==null){
            root = temp;
        }else{
            insert(root,temp);
        }
    }

    public void insert(TreeNode root,TreeNode newNode){
        if(root==null){
            root = newNode;
            return;
        }
        if(newNode.data < root.data){
            if(root.left==null){
                root.left = newNode;
            }else{
                insert(root.left,newNode);
            }
        }else if(newNode.data > root.data){
            if(root.right==null){
                root.right = newNode;
            }else{
                insert(root.right,newNode);
            }
        }
    }

    public void BFS() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BFS_Tree tree = new BFS_Tree();
        Scanner sc = new Scanner(System.in);
        int ch;
        do{
            System.out.println("select choice :> \ninsert\ndisplay");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    tree.create();
                    break;
                case 2:
                    tree.BFS();
                    break;
            }
        }while(ch<=2);
    }
}