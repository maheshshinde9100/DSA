package linkedlist;
import java.util.*;

class SinglyLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node head;
    public SinglyLinkedList() {
        head = null;
    }

    public int get(int index) {
        if(index<0 || head==null) return -1;

        if(index == 0) return head.data;

        int count = 0;
        Node temp = head;
        while(temp!=null && count<index){
            temp = temp.next;
            count++;
        }
        if(temp==null) return -1;
        return temp.data;
    }

    public void insertHead(int val) {
        Node temp = head;
        Node newNode = new Node(val);
        newNode.next = temp;
        head = newNode;
    }

  public void insertTail(int val) {
    Node newNode = new Node(val);
    if (head == null) {
        head = newNode;
        return;
    }

    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = newNode;
}


public boolean remove(int index) {
    if (index < 0 || head == null) return false;

    if (index == 0) {
        head = head.next;
        return true;
    }

    Node temp = head;
    int count = 0;
    while (temp != null && count < index - 1) {
        temp = temp.next;
        count++;
    }

    if (temp == null || temp.next == null) return false;

    temp.next = temp.next.next;
    return true;
}


    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        Node temp = head;
        while(temp!=null){
            res.add(temp.data);
            temp = temp.next;
        }
        return res;
    }

    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();

    list.insertHead(1);       // List: [1]
    list.insertTail(2);       // List: [1, 2]
    list.insertHead(0);       // List: [0, 1, 2]

    // Display current list
    System.out.println("List after insertions:");
    list.display();           // Output: 0   1   2

    System.out.println("\nGet element at index 1: " + list.get(1)); 

    boolean removed = list.remove(1); 
    System.out.println("Removed index 1: " + removed);

    System.out.println("List after removal:");
    list.display();           // Output: 0   2

    list.insertTail(3);       // List: [0, 2, 3]

    System.out.println("\nFinal List:");
    list.display();           // Output: 0   2   3

    ArrayList<Integer> values = list.getValues();
    System.out.println("\nList values as ArrayList: " + values); // [0, 2, 3]
    }
}