package graph;

import java.util.Scanner;

public class AdjacencyList {
    class GraphNode {
        int data;
        int weight;
        GraphNode next;

        GraphNode(int data, int weight) {
            this.data = data;
            this.weight = weight;
            next = null;
        }
    }

        GraphNode graph[] = new GraphNode[100];
        int arr[] = new int[100];
        int v;
        public AdjacencyList(int v,int a[]) {
            this.v = v;
            for(int i=0;i<v;i++){
                arr[i] = a[i];
            }
        }
        public void addEdge(int src,int dest,int weight){
            int srcIndex = getIndex(src);
            int destIndex = getIndex(dest);
            if(srcIndex!=-1 && destIndex!=-1){
                GraphNode newNode = new GraphNode(dest,weight);
                newNode.next = graph[srcIndex];
                graph[srcIndex] = newNode;

                newNode = new GraphNode(src,weight);
                newNode.next = graph[destIndex];
                graph[destIndex] = newNode;
            }else{
                System.out.println("Graph doesn't exist");
            }
        }
        public int getIndex(int x){
            for(int i=0;i<v;i++){
                if(arr[i]==x){
                    return i;
                }
            }
            return -1;
        }

        public void display(){
            for(int i=0;i<v;i++){
                System.out.print(arr[i] + " -> ");
                GraphNode temp = graph[i];
                while(temp!=null){
                    System.out.print(temp.data+" ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
        public static void main(String[] args){
            int v;
            int src,dest,weight;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of vertices");
            v= sc.nextInt();
            int arr[] = new int[v];
            System.out.println("Enter "+v+" vertices :> ");
            for(int i=0;i<v;i++){
                arr[i]= sc.nextInt();
            }

            AdjacencyList obj = new AdjacencyList(v,arr);

            for(int i=0;i<v;i++){
                src = sc.nextInt();
                dest = sc.nextInt();
                weight = sc.nextInt();
                obj.addEdge(src,dest,weight);
            }

            obj.display();
        }
}
