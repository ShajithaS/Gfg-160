/*
link:https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/k-sum-paths
Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. 
A path can start and end at any node within the tree but must always move downward (from parent to child).
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
    int cnt=0;
    public int sumK(Node root, int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        find(root,k,map,0);
        return cnt;
    }
    private void find(Node root,int k,HashMap<Integer,Integer> map,int currsum){
        if(root==null)
        return;
        currsum+=root.data;
        if(map.containsKey(currsum-k))
            cnt+=map.get(currsum-k);
        map.put(currsum,map.getOrDefault(currsum,0)+1);
        find(root.left,k,map,currsum);
        find(root.right,k,map,currsum);
        map.put(currsum,map.get(currsum)-1);
        
    }
}
