/*
link:https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/find-a-pair-with-given-target-in-bst
Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
          bst-3
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
  */

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> arr=new ArrayList<>();
    void inorder(Node root){
        if(root==null)
        return;
        inorder(root.left);
        arr.add(root.data);
        inorder(root.right);
    }
    boolean findTarget(Node root, int target) {
        // Write your code here
        inorder(root);
        int left=0;
        int right=arr.size()-1;
        while(left<right){
            int sum=arr.get(left)+arr.get(right);
            if(sum<target)
            left++;
            else if(sum>target)
            right--;
            else return true;
        }
        return false;
    }
}
//Time Complexity	:O(N)
//Space Complexity:	O(N) [O(H) recursion + O(N) storage]
