#include<iostream>
#include<vector>
using namespace std;
struct GraphNode{
    int data,weight;
    GraphNode* next;
    GraphNode(int data,int weight){
        this->data = data;
        this->weight = weight;
        next = nullptr;
    }
};
class Graph{
    public:
    GraphNode* arr[100];
    int nums[100];
    int v;
    Graph(int v,int a[]){
        this->v = v;
        for(int i=0;i<v;i++){
            arr[i] = nullptr;
            nums[i] = a[i];
        }
    }

    void addEdge(int src,int dest,int weight){
        int srcIndex = getIndex(src);
        int destIndex = getIndex(dest);
        
        GraphNode* newNode = new GraphNode(dest,weight);
        newNode->next = arr[srcIndex];
        arr[srcIndex] = newNode;

        newNode = new GraphNode(src,weight);
        newNode->next = arr[destIndex];
        arr[destIndex] = newNode;
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
        for(int i=0;i<v;i++){
            cout<<i<<" : ";
            GraphNode* temp = arr[i];
            while(temp!=nullptr){
                cout<<"("<<temp->data<<") -> ";
                temp = temp->next;
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