package tree;
import java.util.*;

public class HuffmanCoding {
     class TreeNode{
        int data;
        int bit;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
//            this.bit = bit;
            left = null;
            right = null;
        }
    }
    private TreeNode root;

     void insert(TreeNode root,int x){
        if(root==null){
            root = new TreeNode(x);
            return;
        }
        if(x < root.data){
            insert(root.left,x);
        }else{
            insert(root.right,x);
        }
    }
    void createTree(PriorityQueue<Integer> minHeap){
        if(minHeap.size()<=1){
           return;
        }
        int x = minHeap.poll();
        int y = minHeap.poll();
        int xy = x+y;
        TreeNode temp = new TreeNode(xy);
        temp.left = new TreeNode(x);
        temp.right = new TreeNode(y);
        insert(root,temp.data);
        minHeap.offer(xy);
        createTree(minHeap);
    }

    void display(TreeNode root){
        if(root==null) return;
        System.out.println(root.data+" :> ");
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
         HuffmanCoding obj = new HuffmanCoding();
        PriorityQueue<Integer> minHeap  = new PriorityQueue<>();
        int[] arr = new int[]{50,40,16,4,56};
        for(int i=0;i<arr.length;i++){
            minHeap.offer(arr[i]);
        }

        obj.createTree(minHeap);
        obj.insert(obj.root, minHeap.poll());
        obj.display(obj.root);
    }

}
