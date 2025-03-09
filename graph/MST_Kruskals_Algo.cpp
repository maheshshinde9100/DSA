#include <iostream>

using namespace std;

#define MAX_EDGES 100  // Maximum edges (Adjust as needed)
#define MAX_VERTICES 100  // Maximum vertices (Adjust as needed)

// Structure to represent an edge
struct Edge {
    int src, dest, weight;
};

// Structure to represent a graph
struct Graph {
    int V, E;  // Number of vertices and edges
    Edge edges[MAX_EDGES];  // Array of edges
};

// Disjoint Set (Union-Find)
struct Subset {
    int parent;
    int rank;
};

// Function to find the parent of a node with path compression
int find(Subset subsets[], int i) {
    if (subsets[i].parent != i) {
        subsets[i].parent = find(subsets, subsets[i].parent);
    }
    return subsets[i].parent;
}

// Function to perform Union of two subsets using rank
void Union(Subset subsets[], int x, int y) {
    int rootX = find(subsets, x);
    int rootY = find(subsets, y);

    if (subsets[rootX].rank < subsets[rootY].rank) {
        subsets[rootX].parent = rootY;
    } else if (subsets[rootX].rank > subsets[rootY].rank) {
        subsets[rootY].parent = rootX;
    } else {
        subsets[rootY].parent = rootX;
        subsets[rootX].rank++;
    }
}

// Simple Bubble Sort to sort edges by weight
void sortEdges(Edge edges[], int E) {
    for (int i = 0; i < E - 1; i++) {
        for (int j = 0; j < E - i - 1; j++) {
            if (edges[j].weight > edges[j + 1].weight) {
                Edge temp = edges[j];
                edges[j] = edges[j + 1];
                edges[j + 1] = temp;
            }
        }
    }
}

// Function to find the Minimum Spanning Tree using Kruskal's Algorithm
void KruskalMST(Graph* graph) {
    int V = graph->V;
    Edge result[MAX_VERTICES];  // Stores MST edges
    int e = 0;  // Number of edges in MST
    int i = 0;  // Index for sorted edges

    // Step 1: Sort edges by weight
    sortEdges(graph->edges, graph->E);

    // Step 2: Initialize subsets for Union-Find
    Subset subsets[MAX_VERTICES];
    for (int v = 0; v < V; v++) {
        subsets[v].parent = v;
        subsets[v].rank = 0;
    }

    // Step 3: Pick the smallest edge and check for cycles
    while (e < V - 1 && i < graph->E) {
        Edge nextEdge = graph->edges[i++];
        int x = find(subsets, nextEdge.src);
        int y = find(subsets, nextEdge.dest);

        // If no cycle is formed, add edge to MST
        if (x != y) {
            result[e++] = nextEdge;
            Union(subsets, x, y);
        }
    }

    // Step 4: Print the MST
    cout << "Edges in the Minimum Spanning Tree (MST):\n";
    for (int j = 0; j < e; j++) {
        cout << result[j].src << " -- " << result[j].dest << " == " << result[j].weight << endl;
    }
}

int main() {
    Graph graph;
    graph.V = 5;
    graph.E = 7;

    graph.edges[0] = {0, 1, 10};
    graph.edges[1] = {0, 2, 6};
    graph.edges[2] = {0, 3, 5};
    graph.edges[3] = {1, 3, 15};
    graph.edges[4] = {2, 3, 4};
    graph.edges[5] = {1, 2, 25};
    graph.edges[6] = {3, 4, 7};

    KruskalMST(&graph);

    return 0;
}
