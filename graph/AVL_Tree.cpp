 #include<iostream>
 using namespace std;
 struct TreeNode{
    int key,height;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int d){
        key = d;
        height = 1;
        left = nullptr;
        right = nullptr;
    }
 };
 TreeNode* root;

 int height(TreeNode* root){
    if(root==nullptr){
        return 0;
    }else{
        return root->height;
    }
 }

 int getBalance(TreeNode* root){
    if(root==nullptr){
        return 0;
    }
    return height(root->left) - height(root->right);
 }

 TreeNode* rightRotate(TreeNode*& y){
    TreeNode* x = y->left;
    TreeNode* t2 = x->right;
    x->right = y;
    y->left = t2;
    y->height = max(height(y->left),height(y->right)) + 1;
    x->height = max(height(x->left),height(x->right)) + 1;
    return x;
 }

 TreeNode* leftRotate(TreeNode*& x){
    TreeNode* y = x->right;
    TreeNode* t2 = y->left;

    y->left = x;
    x->right = t2;

    x->height = max(height(x->left),height(x->right)) + 1;
    y->height = max(height(y->left),height(y->right)) + 1;
    return y;
 }

 TreeNode* insert(TreeNode*& root, int key){
    if(root==nullptr){
        return new TreeNode(key);
    }

    if(key<root->key){
        root->left = insert(root->left,key);
    }else if(key > root->key){
        root->right = insert(root->right, key);
    }else{
        return root;
    }


    root->height = 1+max(height(root->left),height(root->right));
    int balance = getBalance(root);

    if(balance > 1 && key<root->left->key){
        return rightRotate(root);
    }

    if(balance > -1 && key>root->right->key){
        return leftRotate(root);
    }

    if(balance > 1 && key>root->left->key){
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }

    if(balance > -1 && key<root->right->key){
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }

    return root;
 }

 void preorder(TreeNode* root){
    if(root!=nullptr){
        cout<<root->key<<"\t";
        preorder(root->left);
        preorder(root->right);
    }
 }

 int main(){
    root = insert(root,10);
    root = insert(root,20);
    root = insert(root,30);
    root = insert(root,40);
    root = insert(root,50);
    root = insert(root,25);
    cout<<"Preorder : AVL -> "<<endl;
    preorder(root);
    return 0;
 }