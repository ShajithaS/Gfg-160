/*
Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.
Input: root[] = [1, 2, 3]

Output: [[1], [2, 3]]
Input: root[] = [10, 20, 30, 40, 50]

Output: [[10], [20, 30], [40, 50]]
Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]

Output: [[1], [3, 2], [4], [6, 5]]
*/
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        if(root==null)
        return new ArrayList<>();
        Queue<Node> q =new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        q.add(root);
        int currlevel=0;
        while(!q.isEmpty()){
            int len=q.size();
            ans.add(new ArrayList<>());
            for(int i=0;i<len;i++){
                Node node =q.poll();
                ans.get(currlevel).add(node.data);
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
            }
            currlevel++;;
        }
        return ans;
    }
}
//O(n) Time and O(n) Space
