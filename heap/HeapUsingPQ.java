package heap;
import java.util.*;
public class HeapUsingPQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //maxHeap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); //minHeap
        int x,ch;
        do{
            System.out.println("\n1.insert\n2.get root\n3.delete root\n.display");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("ENter element to insert :>");
                    x = sc.nextInt();
                    insert(pq,x);
                    break;
                case 2:
                    System.out.println("Top :> " +pq.peek());
                    break;
                case 3:
                    System.out.println("deleted top :> " +pq.poll());
                    break;
                case 4:
                    display(pq);
                    break;
                default:
                    break;
            }
        }while(ch<=4);

    }
    static void insert(PriorityQueue<Integer> pq, int element){
        pq.offer(element);
    }
    static void display(PriorityQueue<Integer> pq){
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
    
}
