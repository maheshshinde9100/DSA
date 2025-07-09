package heap;

import java.util.*;

class MinHeapOperation
{
    
    List<Integer> heap;
    MinHeapOperation(){
        heap = new ArrayList<>();
    }
    
int leftChild(int i){
    return 2*i+1;
}
int rightChild(int i){
    return 2*i+2;
}
int parent(int i){
    return (i-1)/2;
}
void heapifyUp(int index){
    while(index>0 && heap.get(parent(index)) > heap.get(index)){
        swap(index,parent(index));
        index = parent(index);
    }
}
void insert(int value){
    heap.add(value);
    heapifyUp(heap.size()-1);
}

void display(){
	    for(Integer j: heap){
	        System.out.print(j+" ");
	    }
	    System.out.println();
}

void swap(int i,int j){
    int temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
}
	public static void main (String[] args) throws java.lang.Exception
	{
	// your code goes here
	Scanner sc = new Scanner(System.in);
	MinHeapOperation obj = new MinHeapOperation();

	int n = sc.nextInt();
	int[] arr = new int[n];
	for(int i=0;i<n;i++){
	    arr[i] = sc.nextInt();
	}
	
	    for(int i=0;i<n;i++){
	        obj.insert(arr[i]);
	        obj.display();
	    }
}
}
