#include<iostream>
#include<vector>
using namespace std;
class Graph{
    public:
    int nums[100];
    int g[100][100];
    int v;
    Graph(int v,int a[]){
        this->v = v;
        for(int i=0;i<v;i++){
            nums[i] = a[i];
            for(int j=0;j<v;j++){
                g[i][j] = 0;
            }
        }
    }

    void addEdge(int src,int dest,int weight){
        int srcIndex = getIndex(src);
        int destIndex = getIndex(dest);
        
        if(srcIndex!= -1 && destIndex!=-1){
            //undirected graph
            g[srcIndex][destIndex] = weight;
            g[destIndex][srcIndex] = weight;
        }
    }

    int getIndex(int data){
        for(int i=0;i<v;i++){
            if(nums[i]==data){
                return i;
            }
        }
        return -1;
    }

    void display(){
        cout<<"Adjacency Matrix :> "<<endl;
        for(int i=0;i<v;i++){
            cout<<nums[i]<<" :\t";
            for(int j=0;j<v;j++){
                cout<<g[i][j]<<"\t";
            }
            cout<<endl;
        }
    }
};
int main(){
    int v;
    int src,dest,weight;
    cout<<"Enter no of vertices :> "<<endl;
    cin>>v;
    int nums[v];
    cout<<"Enter "<<v<<" vertices :>"<<endl;
    for(int i=0;i<v;i++){
        cin>>nums[i];
    }

    Graph g(v,nums);

    for(int i=0;i<v;i++){
        cout<<"Enter src,dest,weight :> "<<endl;
        cin>>src>>dest>>weight;
        g.addEdge(src,dest,weight);
    }
    g.display();
    return 0;
}