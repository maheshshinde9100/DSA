#include <iostream>
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
};

// Preorder traversal function (Root -> Left -> Right)
void preorderTraversal(TreeNode* root) {
    if (root == nullptr) return;
    cout << root->data << " ";

    preorderTraversal(root->left);
    preorderTraversal(root->right);
}

int main() {
    // Create a sample tree
    //      1
    //     / \
    //    2   3
    //   / \
    //  4   5

    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);

    cout << "Preorder Traversal :> ";
    preorderTraversal(root);
    cout << endl;
    return 0;
}