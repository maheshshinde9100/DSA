package tree;
import java.util.*;

class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
 
    }

public class BinaryTreePaths {
    Scanner sc = new Scanner(System.in);
        void insert(TreeNode root, TreeNode newNode){
            if(root==null){
                root = newNode;
                return;
            }
        System.out.println("1.left\t2.right :>");
           int ch = sc.nextInt();
           switch(ch){
            case 1:
                if(root.left == null){
                    root.left = newNode;
                }else{
                    insert(root.left, newNode);
                }
                break;
            case 2:
                if(root.right == null){
                    root.right = newNode;
                }else{
                    insert(root.right, newNode);
                }
                break;
            default:
                System.out.println("invalid choice..");
           }
        }

        void binaryTreePaths(TreeNode root, List<String> list,StringBuffer str){
            if(root==null){
                return;
            }
            int len = str.length();
            str.append(root.data);
            if(root.left == null && root.right==null){
                list.add(str.toString());
            }else{
                str.append(" -> ");
            
            binaryTreePaths(root.left, list,str);
            binaryTreePaths(root.right, list,str);
            }
            str.setLength(len);
        }

    public static void main(String[] args) {
        /*
         *      1
         *    2     3
         *   5
         * op:> ["1->2->5","1->3"]
         */
        BinaryTreePaths obj = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter elements to insert -> ");
        for(int i=0;i<3;i++){
            int x = sc.nextInt();
            obj.insert(root, new TreeNode(x));
        }

        obj.binaryTreePaths(root, list,new StringBuffer());
        for(String str: list){
            System.out.println(str+"\t");
        }
    }
}
