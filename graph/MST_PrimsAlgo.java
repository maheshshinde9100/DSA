package graph;

import java.util.*;

class Graph {
    int V;
    int E;
    List<List<int[]>> adjList; //list of list : [[u,v,w],[u,v,w],.....]

    Graph(int v, int e) {
        this.V = v;
        this.E = e;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new int[]{dest, weight});
        adjList.get(dest).add(new int[]{src, weight});
    }

    public void display() {
        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + ": ");
            for (int[] edge : adjList.get(i)) {
                System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
            }
            System.out.println();
        }
    }

    List<String> minimumSpanningTree(int src) {
        List<String> mstEdges = new ArrayList<>();
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // (node, weight, parent)
        
        pq.offer(new int[]{src, 0, -1}); // Start from source node

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int weight = curr[1];
            int parent = curr[2];

            if (visited[u]) continue;
            visited[u] = true;

            if (parent != -1) {
                mstEdges.add("(" + parent + "," + u + ") -> " + weight);
            }

            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (!visited[v]) {
                    pq.offer(new int[]{v, w, u});
                }
            }
        }

        return mstEdges;
    }
}

public class MST_PrimsAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v, e;
        System.out.println("Enter number of vertices: ");
        v = scanner.nextInt();
        System.out.println("Enter number of edges: ");
        e = scanner.nextInt();

        Graph g = new Graph(v, e);
        for (int i = 0; i < e; i++) {
            System.out.println("Enter (start vertex, destination vertex, weight): ");
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            g.addEdge(src, dest, weight);
        }

        g.display();

        System.out.println("Enter source vertex: ");
        int src = scanner.nextInt();

        List<String> mst = g.minimumSpanningTree(src);
        System.out.println("Minimum Spanning Tree:");
        for (String edge : mst) {
            System.out.println(edge);
        }
    }
}
