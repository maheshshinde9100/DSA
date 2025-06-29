package graph;
import java.util.Scanner;
public class Graph{
    int[] nums = new int[100];
    int[][] g = new int[100][100];
    int V;
    Graph(int V,int a[]){
        this.V = V;
        for(int i=0;i<V;i++){
            nums[i] = a[i];
            for(int j=0;j<V;j++){
                g[i][j] = 0;
            }
        }
    }
    void addEdge(int u,int v,int weight){
        int srcIndex = getIndex(u);
        int destIndex = getIndex(v);
        if(srcIndex==-1 || destIndex==-1){
            System.out.println("Not found..");
            return;
        }else{
 g[u][v] = weight;
        g[v][u] = weight;
        }
    }
    int getIndex(int data){
        for(int i=0;i<V;i++){
            if(nums[i]==data){
                return i;
            }
        }
        return -1;
    }

    void display(){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(g[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Vertices :> ");
        int V = sc.nextInt();
        int[] vertices = new int[V];
        for(int i=0;i<V;i++){
            vertices[i] = sc.nextInt();
        }

        Graph g = new Graph(V,vertices);
        System.out.println("Enter src,dest,weight :>");
        for(int i=0;i<V;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            g.addEdge(src,dest,weight);
        }

        g.display();
    }
}