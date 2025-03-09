#include <iostream>
using namespace std;

#define MAX 100  // Maximum vertices or edges
#define INF 99999 // Infinite weight for no connection

struct Edge {
    int src, dest, weight;
};

struct Subset {
    int parent, rank;
};

int find(int parent[], int i) {
    if (parent[i] == i)
        return i;
    return parent[i] = find(parent, parent[i]); // Path Compression
}

void Union(int parent[], int rank[], int x, int y) {
    int rootX = find(parent, x);
    int rootY = find(parent, y);

    if (rank[rootX] < rank[rootY]) {
        parent[rootX] = rootY;
    } else if (rank[rootX] > rank[rootY]) {
        parent[rootY] = rootX;
    } else {
        parent[rootY] = rootX;
        rank[rootX]++;
    }
}

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

void KruskalMST(Edge edges[], int V, int E) {
    sortEdges(edges, E);  // Step 1: Sort edges by weight

    int parent[MAX], rank[MAX];
    for (int v = 0; v < V; v++) {
        parent[v] = v;  // Initialize parent of each vertex
        rank[v] = 0;    // Rank is 0
    }

    Edge result[MAX];  // Store MST edges
    int e = 0;        // Count edges in MST
    int i = 0;        // Index for edges

    while (e < V - 1 && i < E) {
        Edge nextEdge = edges[i++];

        int x = find(parent, nextEdge.src);
        int y = find(parent, nextEdge.dest);

        if (x != y) {  // No cycle
            result[e++] = nextEdge;
            Union(parent, rank, x, y);
        }
    }

    cout << "Edges in the Minimum Spanning Tree:\n";
    for (int j = 0; j < e; j++) {
        cout << result[j].src << " -- " << result[j].dest << " == " << result[j].weight << endl;
    }
}

int main() {
    int V = 5, E = 7;
    Edge edges[] = {
        {0, 1, 10}, {0, 2, 6}, {0, 3, 5},
        {1, 3, 15}, {2, 3, 4}, {1, 2, 25}, {3, 4, 7}
    };

    KruskalMST(edges, V, E);

    return 0;
}
