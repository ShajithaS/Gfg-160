/*
Problem Link:https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/maximum-path-sum-from-any-node
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42


Max path sum is represented using green colour nodes in the above binary tree.
Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31


Max path sum is represented using green colour nodes in the above binary tree.
  */

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}


class Solution {
    // Function to return maximum path sum from any node in a tree.
    int ans=Integer.MIN_VALUE;
    int findMaxSum(Node node) {
        // your code goes here
        find(node);
        return  ans;
    }
    int find(Node node){
        if(node==null)
        return 0;
        int left=Math.max(find(node.left),0);
        int right=Math.max(find(node.right),0);
        ans=Math.max(ans,node.data+left+right);
        return Math.max(left,right)+node.data;
        
    }
}
