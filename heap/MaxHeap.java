package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxHeap{

    static List<Integer> heap = new ArrayList<>();

    static int getParent(int i){
        return (i-1)/2;
    }
    // static int leftChild(int i){
    //     return 2*i+1;
    // }
    // static int rightChild(int i){
    //     return 2*i+2;
    // }

    static void swap(int i,int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,temp);
    }
    static void heapifyUp(int index){
        while(index > 0 && heap.get(index) > heap.get(getParent(index))){  //when child is greater than parent
            swap(index, getParent(index));
            index = getParent(index);
        }
    }
    static void insert(int element){
        heap.add(element);
        heapifyUp(heap.size()-1);
    }
    static void display(){
        for(Integer x: heap){
            System.out.print(x+"\t");
        }
    }


    public static void main(String[] args) {
        try{
        int ch = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.insert\n2.get Max\n3.display");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter num to insert:> ");
                    int n = sc.nextInt();
                    insert(n);
                    break;
                case 2:
                    System.out.println("Max root :> "+heap.getFirst());
                    break;
                case 3:
                    display();
                    break;
            }
        }while(ch>3);
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    // insert(1);
    // insert(9);
    // insert(4);
    // insert(6);
    // insert(3);
    // insert(7);
    // insert(2);    
    System.out.println("MAX root :> "+heap.getFirst());   // Root contains maximum from heap
    System.out.println(heap);
   }
}