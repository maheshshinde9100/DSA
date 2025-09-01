//package graph;
//
//import java.util.Arrays;
//
//public class DijkstraAlgorithm {
//    class GraphNode {
//        int data;
//        int weight;
//        GraphNode next;
//
//        GraphNode(int data, int weight) {
//            this.data = data;
//            this.weight = weight;
//            next = null;
//        }
//    }
//        GraphNode adjList[];
//        int V;
//        int[] arr;
//
//        DijkstraAlgorithm(int V,int[] elements){
//            this.V = V;
//            adjList = new GraphNode[V];
//            arr = new int[V];
//            for(int i=0;i<V;i++){
//                arr[i] = elements[i];
//            }
//        }
//
//        public void addEdge(int src,int dest,int weight){
//            int srcIndex = getIndex(src);
//            int destIndex = getIndex(dest);
//            if(srcIndex ==-1 || destIndex==-1){
//                return;
//            }
//            GraphNode node = new GraphNode(src,weight);
//            node.next = adjList[destIndex];
//            adjList[destIndex] = node;
//
//            node = new GraphNode(dest,weight);
//            node.next = adjList[srcIndex];
//            adjList[srcIndex] = node;
//
//        }
//        public int getIndex(int vertex){
//            for(int i=0;i<V;i++){
//                if(arr[i]==vertex){
//                    return i;
//                }
//            }
//            return -1;
//        }
//
//    public void display(){
//        for(int i=0;i<V;i++){
//            System.out.print("\n"+arr[i]+" -> ");
//            GraphNode temp = adjList[i];
//            while(temp!=null){
//                System.out.print("("+temp.data+","+temp.weight+") ->\t");
//                temp = temp.next;
//            }
//        }
//    }
//
//    public void Dijkstra(int start){
//            boolean[] visited = new boolean[V];
//            int[] distance = new int[V];
//
//            Arrays.fill(visited,false);
//            Arrays.fill(distance,99999);
//
//            visited[start] = true;
//            distance[start] = 0;
//
//            for(int i=0;i<V;i++){
//                int u = getMinIndex(distance,visited);
//                visited[u] = true;
//                for(int v=0; v<V; v++){
//                    if(!visited[v] && distance[u] + g[u][v] < distance[v]){
//                        distance[v] = distance[u] + g[u][v];
//                    }
//                }
//            }
//    }
//    int getMinIndex(int[] distance,boolean[] visited){
//            int min=99999,minIndex = -1;
//            for(int i=0;i<V;i++){
//                if(!visited[i] && distance[i]<min){
//                    min = distance[i];
//                    minIndex =i;
//                }
//            }
//            return minIndex;
//    }
//
//        public static void main(String[] args) {
//            int V = 3;
//            int[] arr = {10,20,30};
//            DijkstraAlgorithm obj = new DijkstraAlgorithm(V,arr);
//            obj.addEdge(10,20,100000);
//            obj.addEdge(20,30,2000000);
//            obj.addEdge(30,10,3000000);
//
//            obj.display();
//    }
//}
