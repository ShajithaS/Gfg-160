/*
link:https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2). You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA) of the given two nodes in the BST.

LCA between two nodes n1 and n2 is defined as the lowest node that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).

Examples:

Input: root = [5, 4, 6, 3, N, N, 7, N, N, N, 8], n1 = 7, n2 = 8
        
Output: 7
Explanation: 7 is the closest node to both 7 and 8, which is also an ancestor of both the nodes.
Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], n1 = 8, n2 = 14
                
Output: 8
Explanation: 8 is the closest node to both 8 and 14, which is also an ancestor of both the nodes.
Input: root = [2, 1, 3], n1 = 1, n2 = 3
        
Output: 2
Explanation: 2 is the closest node to both 1 and 3, which is also an ancestor of both the nodes.
*/
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}


class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        if(root==null)
        return null;
        int curr=root.data;
        if(curr<n1.data && curr<n2.data){
            return(LCA(root.right,n1,n2));
        }
        if(curr>n1.data && curr>n2.data){
            return(LCA(root.left,n1,n2));
        }
        return root;
    }
}
//Time complexity:O(n),Space Complexity:O(h)
