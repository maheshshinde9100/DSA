#include<iostream>
using namespace std;
struct Node{
    int data;
    Node* next;
    Node(int val){
        data = val;
        next = nullptr;
    }
}*h;
void insertAtHead(Node* head,int x){
    if(head==nullptr) {
        Node* temp = new Node(x);
        head = temp;
    }else{
        Node* temp = new Node(x);
        temp->next = head;
        head = temp;
    }
}
void insertAtMiddle(Node* head,int x){
    int pos;
    cout<<"Enter possition to insert New Node :? "<<endl;
    cin>>pos;
    if(head==nullptr) {
        cout<<"Not possible at "<<pos<<" cause head is NULL !"<<endl;
        return;
    }else{
        int count = 0;
        Node* temp = new Node(x);
        Node* h = head;
        while(h->next){
            count++;
            if(count==pos){
                temp->next = h->next;
                h->next = temp;
            }
            h = h->next;
        }
    }
}
void insertAtLast(Node* head,int x){
    Node* temp = new Node(x);
    if(head==nullptr) {
        head = temp;
    }else{
        Node* temp2 = head;
        while(temp2->next != nullptr){
            temp2= temp2->next;
        }
        temp2->next = temp;
    }
}
void insertNode(Node* head,int x){
    int ch;
    cout<<"Where you want to insert node :> 1.head \n2.middle \n3.last ???"<<endl;
    cin>>ch;
    switch(ch){
        case 1:
            insertAtHead(head,x);
            break;
        case 2:
            insertAtMiddle(head,x);
            break;
        case 3:
            insertAtLast(head,x);
            break;
    }
}
void deleteNode(Node* head){
    //delete from last
}
void displayLL(Node* head){

}
int main(){
    h = nullptr;
    int ch,c,x;
    do{
        cout<<"Select Operation on Singly Linked-List"<<endl;
        cout<<"1.insert node"<<endl;
        cout<<"2.delete node"<<endl;
        cout<<"3.display linked list"<<endl;
        cin>>ch;
        switch(ch){
            case 1:
                cout<<"Enter value :> "<<endl;
                cin>>x;
                insertNode(h,x);
                break;
            case 2:
                deleteNode(h);
                break;
            case 3:
                displayLL(h);
                break;
            default:
                cout<<"Invalid option selecttion...."<<endl;
        }
        cout<<"Do you want to continue (1/0)"<<endl;
        cin>>c;
    }while(c==1);
    return 0;
}
