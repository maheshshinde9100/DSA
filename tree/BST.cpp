#include<iostream>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val) {
        data = val;
        left = nullptr;
        right = nullptr;
    }
} *root;

void insert(TreeNode*& root1, TreeNode* newNode) { // Change root1 to reference
    if (root1 == nullptr) {
        root1 = newNode;
        return;
    } else {
        if (newNode->data < root1->data) {
            insert(root1->left, newNode);
        } else {
            insert(root1->right, newNode);
        }
    }
}

void create(TreeNode*& root1) { // Change root1 to reference
    int x;
    cout << "Enter new node data :> ";
    cin >> x;
    TreeNode* newNode = new TreeNode(x);
    insert(root1, newNode);
}

TreeNode* deleteNode(TreeNode* root1, int key) {
    if (root1 == nullptr) {
        return root1;
    } else if (key < root1->data) {
        root1->left = deleteNode(root1->left, key);
    } else if (key > root1->data) {
        root1->right = deleteNode(root1->right, key);
    } else {
        // case1 - leaf node
        // case2 - having one child
        // case3 - having both child
        if (root1->left == nullptr && root1->right == nullptr) {
            cout << "Leaf node deleted.." << endl;
            delete root1;
            return nullptr;
        } else if (root1->left == nullptr) {
            cout << "having one child node deleted.." << endl;
            TreeNode* temp = root1->right;
            delete root1;
            return temp;
        } else if (root1->right == nullptr) {
            cout << "having one child node deleted.." << endl;
            TreeNode* temp = root1->left;
            delete root1;
            return temp;
        } else { // both
            cout << "Parent node deleted.." << endl;
            TreeNode* temp = root1->right;
            while (temp->left) {
                temp = temp->left;
            }
            root1->data = temp->data;
            root1->right = deleteNode(root1->right, temp->data);
        }
    }
    return root1;
}

void deletion(TreeNode* root1) {
    if (root1 == nullptr) {
        cout << "deletion is not possible..." << endl;
        return;
    } else {
        int x;
        cout << "Enter data of Node to be Deleted..." << endl;
        cin >> x;
        deleteNode(root, x);
    }
}

int main() {
    int c, ch;
    root = nullptr;
    do {
        cout << "1.insert\n2.delete" << endl;
        cin >> ch;
        switch (ch) {
            case 1:
                create(root);
                break;
            case 2:
                deletion(root);
                break;
            default:
                cout << "invalid choice..." << endl;
        }
        cout << "continue(1/0)" << endl;
        cin >> c;
    } while (c == 1);
    return 0;
}