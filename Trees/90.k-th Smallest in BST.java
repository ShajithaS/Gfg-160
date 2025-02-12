/*
Question link:https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/find-k-th-smallest-element-in-bst
Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

Examples:

Input: root = [2, 1, 3], k = 2
    
Output: 2
Explanation: 2 is the 2nd smallest element in the BST.
Input: root = [2, 1, 3], k = 5
    
Output: -1
Explanation: There is no 5th smallest element in the BST as the size of BST is 3.
Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 3
     
Output: 10
Explanation: 10 is the 3rd smallest element in the BST.
  */

//approach 1
// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        if(k>arr.size())
        return -1;
        return arr.get(k-1);
    }
    void inorder(Node node,ArrayList<Integer> arr)
    {
        if(node==null)
        return;
    inorder(node.left,arr);
    arr.add(node.data);
    inorder(node.right,arr);
}
}
//Using ArrayList (Recursive Inorder)	TC:O(N)	SC:O(N)

//approach 2
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st=new Stack<>();
        int cnt=0;
        TreeNode curr=root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            cnt++;
            if(cnt==k)
            return curr.val;
            curr=curr.right;
        }
        return -1;
    }
}
//Time: O(N)	Visits each node once
//Space: O(H)	Height of the tree (O(logN) for balanced BST, O(N) for skewed)
