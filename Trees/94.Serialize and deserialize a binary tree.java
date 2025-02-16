/*
Question link:https://www.geeksforgeeks.org/batch/gfg-160-problems/track/tree-gfg-160/problem/serialize-and-deserialize-a-binary-tree
Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).
  */

class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}

class Tree {
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
        return ans;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node==null){
            ans.add(-1);
            continue;
        }
        ans.add(node.data);
        q.add(node.left);
        q.add(node.right);
        }
        return ans;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        if(arr.size()==0)
        return null;
        Queue<Node> q=new LinkedList<>();
        Node root=new Node(arr.get(0));
        q.add(root);
        for(int i=1;i<arr.size();i++){
            Node parent=q.poll();
            if(arr.get(i)!=-1){
                Node left=new Node(arr.get(i));
                parent.left=left;
                q.add(left);
        }
        if(arr.get(++i)!=-1){
            Node right=new Node(arr.get(i));
            parent.right=right;
            q.add(right);
        }
    }
    return root;
}
}
//TC:O(n)
//SC:O(n)
