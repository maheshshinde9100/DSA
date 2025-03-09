#include <iostream>
using namespace std;

#define V 5       // Number of vertices in the graph
#define INF 99999 // A large number representing "infinity"

// Function to find the vertex with the minimum distance that has not been visited yet
int getMinVertex(int shortestDist[], bool visited[]) {
    int minDist = INF, minIndex = -1;

    for (int v = 0; v < V; v++) {
        if (!visited[v] && shortestDist[v] < minDist) { // Find the minimum unvisited vertex
            minDist = shortestDist[v];
            minIndex = v;
        }
    }
    return minIndex;
}

// Function to print the shortest distances from the source vertex
void printShortestPaths(int shortestDist[]) {
    cout << "Vertex \t Shortest Distance from Source" << endl;
    for (int i = 0; i < V; i++) {
        cout << i << " \t\t " << shortestDist[i] << endl;
    }
}

// Dijkstra's Algorithm Implementation
void dijkstra(int graph[V][V], int src) {
    int shortestDist[V]; // Stores shortest distance from source to each vertex
    bool visited[V];     // Keeps track of visited vertices

    // Step 1: Initialize all distances as "infinity" and mark all vertices as unvisited
    for (int i = 0; i < V; i++) {
        shortestDist[i] = INF;
        visited[i] = false;
    }

    // Step 2: Distance from source to itself is always 0
    shortestDist[src] = 0;

    // Step 3: Process all vertices
    for (int i = 0; i < V - 1; i++) { // Run for V-1 times (as last vertex is auto-handled)
        int u = getMinVertex(shortestDist, visited); // Pick the closest unvisited vertex
        visited[u] = true; // Mark it as visited

        // Step 4: Update distances of adjacent vertices
        for (int v = 0; v < V; v++) {
            if (!visited[v] && graph[u][v] != 0 && shortestDist[u] + graph[u][v] < shortestDist[v]) {
                shortestDist[v] = shortestDist[u] + graph[u][v];
            }
        }
    }

    // Step 5: Print the shortest distances
    printShortestPaths(shortestDist);
}

// Main function
int main() {
    // Example graph represented as an adjacency matrix
    int graph[V][V] = {
        {0, 10, 0, 30, 100},
        {10, 0, 50, 0, 0},
        {0, 50, 0, 20, 10},
        {30, 0, 20, 0, 60},
        {100, 0, 10, 60, 0}
    };

    dijkstra(graph, 0); // Source vertex is 0

    return 0;
}
