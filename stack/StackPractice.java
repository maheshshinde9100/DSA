package stack;
import java.util.Scanner;
public class StackPractice{
    static int MAX = 10;
    static class Stack{
        int[] data = new int[MAX];
        int top = -1;
    }
    public static void main(String[] args){
        Stack s = new Stack();
        int MAX = StackPractice.MAX;
        int temp,ch;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("choice :>");
            System.out.println("1.push\n2.pop\n3.display\n4.clear");
            ch = sc.nextInt();

            switch(ch){
                case 1:
                    if(s.top == MAX-1){
                        System.out.println("stack overflow");
                    }else{
                        System.out.println("enter element to insert :> ");
                        temp = sc.nextInt();

                        s.top++;
                        s.data[s.top] = temp;
                    }
                    break;

                case 2:
                    if(s.top == -1){
                        System.out.println("stack underflow");
                    }else{
                        System.out.println("element popped :> "+s.data[s.top]);
                        s.data[s.top] = 0;
                        s.top--;
                    }
                    break;

                case 3:
                    System.out.println("From 0 to MAX-1 ->\n");
                    for(int i=0;i<s.data.length;i++){
                        System.out.print(s.data[i]+"\t");
                    }
                    System.out.println();
                    break;

                case 4:
                    for(int i=0;i<s.data.length;i++){
                        s.data[i] = 0;
                    }
                    s.top = -1;
                    break;
            }
        }while(ch<=4);
        System.out.println("invalid choice ...");
    }
}