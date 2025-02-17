#include<iostream>
#define MAX 10
using namespace std;
struct queue {
    int front, rear;
    int data[MAX];
}q;

int main() {
    q.front = -1;
    q.rear = -1;
    int ch, c, x;
    do {
        cout << "Select QUEUE operation :>" << endl;
        cout << "1. Enqueue" << endl;
        cout << "2. Dequeue" << endl;
        cout << "3. Element at front" << endl;
        cout << "4. Element at rear" << endl;
        cout << "5. Display queue" << endl;
        cin >> ch;
        switch (ch) {
            case 1:
                if (q.rear == MAX - 1) {
                    cout << "Queue is full" << endl;
                } else {
                    if (q.front == -1) {
                        q.front = 0;
                    }
                    cout << "Enter element to insert :> " << endl;
                    cin >> x;
                    q.data[++q.rear] = x;
                }
                break;
            case 2:
                if (q.front == -1 || q.front > q.rear) {
                    cout << "Queue is empty" << endl;
                    q.front = q.rear = -1; // Reset the queue
                } else {
                    cout << "Element deleted :> " << q.data[q.front++] << endl;
                    if (q.front > q.rear) {
                        q.front = q.rear = -1; // Reset the queue
                    }
                }
                break;
            case 3:
                if (q.front != -1) {
                    cout << "Element at front :> " << q.data[q.front] << endl;
                } else {
                    cout << "Queue is empty" << endl;
                }
                break;
            case 4:
                if (q.rear != -1) {
                    cout << "Element at rear :> " << q.data[q.rear] << endl;
                } else {
                    cout << "Queue is empty" << endl;
                }
                break;
            case 5:
                if (q.front != -1) {
                    for (int i = q.front; i <= q.rear; i++) {
                        cout << q.data[i] << endl;
                    }
                } else {
                    cout << "Queue is empty" << endl;
                }
                break;
            default:
                cout << "Invalid choice" << endl;
        }
        cout << "Do you want to continue? (1/0)" << endl;
        cin >> c;
    } while (c == 1);
    return 0;
}