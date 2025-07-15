package tree;

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
        TreeNode temp = root;
        while(root!=null){
            System.out.println("\t"+temp.data);
            temp= temp.left;
        }
        temp = root;
        while(root!=null){
            System.out.println("\t"+temp.data);
            temp= temp.right;
        }
    }
    public static void main(String[] args) {
        /* Tree Structure
                                 40
                       30                 50
                   10       20        45        55
                5      15 18   25  41    48  51      60

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
        root.right.right.left = new TreeNode(51);
        root.right.right.right = new TreeNode(60);

        print(root);
    }
}
