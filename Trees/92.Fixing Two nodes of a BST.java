/*
link:https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/fixed-two-nodes-of-a-bst
Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).
 
Examples :
Input: root = [10, 5, 8, 2, 20]
Output: 1
Explanation: The nodes 20 and 8 were swapped.

Input: root = [5, 10, 20, 2, 8]
Output: 1     
Explanation: The nodes 10 and 5 were swapped.
*/


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


class Solution {
    Node first,middle,last,prev;
    void correctBST(Node root) {
        // code here.
        first=middle=last=null;
        prev=new Node(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null && last!=null){
            int t=first.data;
            first.data=last.data;
            last.data=t;
        }
        else if(first!=null && middle!=null){
            int t=first.data;
            first.data=middle.data;
            middle.data=t;
        }
    }
    void inorder(Node root){
        if(root==null)
        return;
        inorder(root.left);
        if(prev!=null && root.data<prev.data){
            if(first==null){
            first=prev;
            middle=root;
            }
            else
            last=root;
        }
        prev=root;
        inorder(root.right);
    }
}
//Time Complexity:O(n)
//Space Complexity:O(n)
