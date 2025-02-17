#include <iostream>
using namespace std;
struct TreeNode {
    string data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(string value) {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};

// Preorder traversal (Root -> Left -> Right)
void preOrder(TreeNode* node) {
    if (node == nullptr) return;
    cout << node->data << " ";
    preOrder(node->left);
    preOrder(node->right);
}
int main() {
    TreeNode* root = new TreeNode("Root");
    root->left = new TreeNode("Left");
    root->right = new TreeNode("Right");
    root->left->left = new TreeNode("Left.Left");
    root->left->right = new TreeNode("Left.Right");
    cout << "Preorder Traversal of the Tree:" << endl;
    preOrder(root);
    return 0;
}