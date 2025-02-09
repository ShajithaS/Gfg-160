/*
Problem link:https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/boundary-traversal-of-binary-tree
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Examples:

Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]


Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
Output: [1, 2, 4, 6, 5, 7, 8]
As the root doesn't have a right subtree, the right boundary is not included in the traversal.

Input: root[] = [1, N, 2, N, 3, N, 4, N, N] 
    1
     \
      2
       \
        3
         \
          4

Output: [1, 4, 3, 2]
Explanation:
Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
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
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        if(node==null)
        return res;
        res.add(node.data);
        if(node.left==null && node.right==null)
        return res;
        if(node.left!=null) 
        collectLeft(res,node.left);
        collectLeaf(res,node);
        if(node.right!=null)
        collectRight(res,node.right);
        return res;
    }
    static void collectLeaf(ArrayList<Integer> ans,Node root){
        if(root== null)
        return;
        if(root.left==null && root.right==null){
            ans.add(root.data);
            return;
        }
        collectLeaf(ans,root.left);
        collectLeaf(ans,root.right);
    }
    static void collectLeft(ArrayList<Integer> ans,Node root){
        if(root==null || (root.left==null && root.right==null))
        return;
        ans.add(root.data);
        if(root.left!=null)
        collectLeft(ans,root.left);
        else
        collectLeft(ans,root.right);
        
    }
    
    static void collectRight(ArrayList<Integer> ans,Node root){
        if(root==null || (root.left==null && root.right==null))
        return;
        if(root.right!=null)
        collectRight(ans,root.right);
        else
        collectRight(ans,root.left);
        ans.add(root.data);
        
    }
    
}
