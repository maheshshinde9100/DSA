#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// Structure of binary tree
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (!root) return vector<vector<int>>{};
        
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        q.push(root);
        
        while (!q.empty()) {
            vector<int> level;
            int sz = q.size();
            
            for (int i = 0; i < sz; ++i) {
                TreeNode* node = q.front();
                q.pop();
                level.push_back(node->val);
                
                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }
            
            ans.push_back(move(level));  // Use move to optimize
        }
        return ans;
    }
};

// Driver code for testing
int main() {
    TreeNode* root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    Solution sol;
    
    vector<vector<int>> result = sol.levelOrder(root);

    // Print level order traversal
    for (const auto& level : result) {
        for (int num : level) {
            cout << num << " ";
        }
        cout << endl;
    }

    return 0;
}
