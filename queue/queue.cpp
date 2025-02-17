#include<iostream>
#define MAX 10
using namespace std;
struct queue{
    int front = -1;
    int rear = -1;
    int data[MAX];
}q;
int main(){
    int ch,c,x;
    do{
    cout<<"select QUEUE operation :>"<<endl;
    cout<<"1.enque"<<endl;
    cout<<"2.deque"<<endl;
    cout<<"3.element at front"<<endl;
    cout<<"4.element at rear"<<endl;
    cout<<"5.display queue"<<endl;
    cin>>ch;
    switch(ch){
        case 1:
            if(q.rear == MAX-1){
                cout<<"queue is fulll"<<endl;
            }else{
                if(q.front == q.rear){
                    q.front = 0;
                    q.rear = 0;
                }
                cout<<"Enter element to insert :> "<<endl;
                cin>>x;
                q.data[q.rear] = x;
                q.rear++;
            }
            break;
        case 2:
            if(q.rear == q.front){
                cout<<"Queue is empty"<<endl;
            }else{
                if(q.front > q.rear){

                }
            }
            break;
        case 3:
            break;
        case 4:
            break;
        case 5:
            break;
    }
        cout<<"Do you want to continue? (1/0)"<<endl;
        cin>>c;
    }while(c==1);
    return 0;
}