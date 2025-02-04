/*
Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

Examples:

Input: root[] = [1, 2, 3]

Output: 2
Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

Input: root[] = [5, 8, 6, 3, 7, 9]

Output: 4
Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).
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
    int max=0;
    int diameter(Node root) {
        // Your code here
        findheight(root);
        return max;
    }
    int findheight(Node node){
        if(node==null)
        return 0;
        int lh=findheight(node.left);
        int rh=findheight(node.right);
        max=Math.max(max,lh+rh);
        return (1+Math.max(lh,rh));
    }
}
//TC:O(n),SC:O(n)
