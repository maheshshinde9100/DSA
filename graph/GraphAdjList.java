import java.util.ArrayList;
import java.util.Scanner;

public class GraphAdjList {
    class GraphNode{
        int data;
        int weight;
        GraphNode next;
        GraphNode(int data,int weight){
            this.data = data;
            this.weight = weight;
            next = null;
        }
    }

    GraphNode graph[];
    int V;
    int[] arr;

    GraphAdjList(int V,int[] elements){
        this.V = V;
        arr = new int[V];
        graph = new GraphNode[V];

        for(int i=0;i<V;i++){
            arr[i] = elements[i];
        }
    }

public void addEdge(int src,int dest,int weight){

    int srcIndex = getIndex(src);
    int destIndex = getIndex(dest);

    if(srcIndex!= -1 && destIndex!= -1){
        GraphNode newNode = new GraphNode(src,weight);
        newNode.next = graph[destIndex];
        graph[destIndex] = newNode;

        // bidirectional graph
        newNode = new GraphNode(dest,weight);
        newNode.next = graph[srcIndex];
        graph[srcIndex] = newNode;
    }
    else{
        System.out.println("invalid source or destination vertex :> ");
    }
}

public int getIndex(int element){
    for(int i=0;i<V;i++){
        if(arr[i]==element){
            return i;
        }
    }
    return -1;
}


public void display(){
    for(int i=0;i<V;i++){

        System.out.print("\n"+arr[i]+" -> ");
        
        GraphNode temp = graph[i];
        while(temp!=null){
            System.out.print("("+temp.data+","+temp.weight+") ->\t");
            temp = temp.next;
        }
    }
}

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("ENter no of vertices :> ");
        int v = sc.nextInt();

        int arr[]  = new int[v];
        int i = 0;
        while(i<v){
            arr[i] = sc.nextInt();
            i++;
        }

        GraphAdjList obj = new GraphAdjList(v,arr);
        i = 0;
        System.out.println("Enter (src,dest,weight) for "+v+" vertices...");
        while(i<v){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            obj.addEdge(x, y, w);
            i++;
        }
        // obj.addEdge(1,2,1000);
        // obj.addEdge(3,4,200);
        obj.display();
    }
}
