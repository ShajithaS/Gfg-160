/*
Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

Note: The output is written in postorder traversal.

Examples:

Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
Output: [8, 7, 6, 1]


Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [3, 4, 1, 5, 2, 0]


Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
Output: [2, 5, 4, 3, 1]
*/
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int[] preindex={0};
        return tree(map,preorder,preindex,0,inorder.length-1);
    }
    static Node tree( Map<Integer,Integer> map,int preorder[],int[] preindex,int left,int right){
        if(left>right){
            return null;
        }
        int rootval=preorder[preindex[0]];
        preindex[0]++;
        Node root=new Node(rootval);
        int index=map.get(rootval);
        root.left=tree(map,preorder,preindex,left,index-1);
        root.right=tree(map,preorder,preindex,index+1,right);
        return root;
        }
}
//Time Complexity: O(N)
//Space Complexity: O(N)
