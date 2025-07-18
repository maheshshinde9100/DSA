package tree;

import java.util.*;

public class TreePractice {
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static void print(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        print(root.left);
        print(root.right);
    }

    static List<Integer> getRightView(TreeNode root, List<Integer> list){
        if(root==null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode prev = null;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                prev = current;
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
            if(prev!=null){
                list.add(prev.data);
            }
        }
        return list;
    }

    static List<Integer> getLeftView(TreeNode root, List<Integer> list){
        if(root==null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean isFirstLeft = true;
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode current = null;
            for(int i=0;i<size;i++){
                 current = q.poll();
                 if(isFirstLeft){
                     list.add(current.data);
                 }
                 isFirstLeft= false;
                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null) {
                    q.offer(current.right);
                }
            }
            isFirstLeft = true;
        }
        return list;
    }

    public static void main(String[] args) {
        /* Tree Structure
                                 40
                       30                 50
                   10       20        45        55
                5      15 18   25  41    48  51      60

        right view of binary tree:> 40,50,55,60
        left view of binary tree:> 40,30,10,5
         */
        TreeNode root = new TreeNode(40);
        root.left =new TreeNode(30);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(15);
        root.left.right = new TreeNode(20);
        root.left.right.left = new TreeNode(18);
        root.left.right.right = new TreeNode(25);

        root.right = new TreeNode(50);
        root.right.right = new TreeNode(55);
        root.right.right.right= new TreeNode(60);
        root.right.right.left = new TreeNode(51);
        root.right.left = new TreeNode(45);
        root.right.left.left = new TreeNode(41);
        root.right.left.right = new TreeNode(48);

        System.out.println("Preorder traversal :> ");
        print(root);

        /* Right side view */
        System.out.println("\nRight side view:> ");
        List<Integer> list = new ArrayList<>();
        list = getRightView(root,list);
        for(Integer x: list){
            System.out.println(x);
        }
        /* Left side view */
        System.out.println("\nLeft side view:> ");
        list = new ArrayList<>();
        list = getLeftView(root,list);
        for(Integer x: list){
            System.out.println(x);
        }

    }
}
