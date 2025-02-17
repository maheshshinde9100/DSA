#include<iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int val) {
        data = val;
        next = nullptr;
    }
} *h;

void insertAtHead(Node*& head, int x) {
    Node* temp = new Node(x);
    temp->next = head;
    head = temp;
}

void insertAtMiddle(Node* head, int x) {
    int pos;
    cout << "Enter position to insert New Node :? " << endl;
    cin >> pos;
    if (head == nullptr) {
        cout << "Not possible at " << pos << " cause head is NULL !" << endl;
        return;
    } else {
        int count = 1;
        Node* temp = new Node(x);
        Node* h = head;
        while (h != nullptr && count < pos - 1) {
            h = h->next;
            count++;
        }
        if (h == nullptr) {
            cout << "Position out of bounds" << endl;
        } else {
            temp->next = h->next;
            h->next = temp;
        }
    }
}

void insertAtLast(Node*& head, int x) {
    Node* temp = new Node(x);
    if (head == nullptr) {
        head = temp;
    } else {
        Node* temp2 = head;
        while (temp2->next != nullptr) {
            temp2 = temp2->next;
        }
        temp2->next = temp;
    }
}

void insertNode(Node*& head, int x) {
    int ch;
    cout << "Where you want to insert node :> 1.head \n2.middle \n3.last ???" << endl;
    cin >> ch;
    switch (ch) {
        case 1:
            insertAtHead(head, x);
            break;
        case 2:
            insertAtMiddle(head, x);
            break;
        case 3:
            insertAtLast(head, x);
            break;
        default:
            cout << "Invalid choice" << endl;
    }
}

void deleteNode(Node*& head) {
    if (head == nullptr) {
        cout << "List is empty" << endl;
        return;
    }
    if (head->next == nullptr) {
        delete head;
        head = nullptr;
    } else {
        Node* temp = head;
        while (temp->next->next != nullptr) {
            temp = temp->next;
        }
        delete temp->next;
        temp->next = nullptr;
    }
}

void displayLL(Node* head) {
    if (head == nullptr) {
        cout << "List is empty" << endl;
    } else {
        Node* temp = head;
        while (temp != nullptr) {
            cout << temp->data << " -> ";
            temp = temp->next;
        }
        cout << "NULL" << endl;
    }
}

int main() {
    h = nullptr;
    int ch, c, x;
    do {
        cout << "Select Operation on Singly Linked-List" << endl;
        cout << "1.insert node" << endl;
        cout << "2.delete node" << endl;
        cout << "3.display linked list" << endl;
        cin >> ch;
        switch (ch) {
            case 1:
                cout << "Enter value :> " << endl;
                cin >> x;
                insertNode(h, x);
                break;
            case 2:
                deleteNode(h);
                break;
            case 3:
                displayLL(h);
                break;
            default:
                cout << "Invalid option selection...." << endl;
        }
        cout << "Do you want to continue (1/0)" << endl;
        cin >> c;
    } while (c == 1);
    return 0;
}
