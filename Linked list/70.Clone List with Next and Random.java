/*
You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.

Examples:

Input: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
      
Output: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
Explanation: 
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 3 as its RANDOM.
Node 3 points to Node 4 as its NEXT and NULL as its RANDOM.
Node 4 points to NULL as its NEXT and Node 3 as its RANDOM.

Input: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
Output: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
Explanation: 
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 1 as its RANDOM.
Node 3 points to Node 4 as its NEXT and Node 5 as its RANDOM.
Node 4 points to Node 5 as its NEXT and Node 3 as its RANDOM.
Node 5 points to NULL as its NEXT and Node 2 as its RANDOM.

Input: head = [[7, NULL], [7, NULL]]
Output: head = [[7, NULL], [7, NULL]]
Explanation: 
Node 1 points to Node 2 as its NEXT and NULL as its RANDOM.
Node 2 points to NULL as its NEXT and NULL as its RANDOM.
*/
class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}
*/
class Solution {
    public Node cloneLinkedList(Node head) {
        // code here
        if(head==null)
        return null;
        for(Node t=head;t!=null;t=t.next.next){
            Node n=new Node (t.data);
            n.next=t.next;
            t.next=n;
        }
        for(Node t=head;t!=null;t=t.next.next){
            if(t.random!=null){
                t.next.random=t.random.next;
            }
        }
        Node newhead=head.next;
        for(Node t=head;t!=null;t=t.next){
            Node temp=t.next;
            t.next=temp.next;
            if(temp.next!=null)
            temp.next=temp.next.next;
        }
        return newhead;
    }
}

//Time Complexity: O(n), where n is the number of nodes in the linked list. We iterate through the list a constant number of times.
//Space Complexity: O(1)
