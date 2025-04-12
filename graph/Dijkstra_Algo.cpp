#include<iostream>
#define V 5
#define INF 999999
using namespace std;

int getMinIndex(int distance[], bool visited[]){
    int minDist = INF, minIndex = -1; 
    for(int v = 0; v<V; v++){
        if(!visited[v] && distance[v]<minDist){
            minDist = distance[v];
            minIndex = v;
        }
    }
    return minIndex;
}

void printShortestPaths(int distance[]){
    for(int i=0;i<V;i++){
        cout<<i<<" ->\t\t"<<distance[i]<<endl;
    }
}

void dijkstra(int g[V][V],int src){
    bool visited[V];
    int distance[V];

    for(int i=0;i<V;i++){
        visited[i] = false;
        distance[i] = INF;
    }

    distance[src] = 0;

    for(int i=0;i<V-1;i++){
        int u = getMinIndex(distance,visited);
        visited[u] = true;

        for(int v=0; v<V; v++){
            if(!visited[v] && g[u][v] != 0 && distance[u] + g[u][v] < distance[v]){
                distance[v] = distance[u] + g[u][v];
            }
        }
    }

    //print
    printShortestPaths(distance);
}

int main(){
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