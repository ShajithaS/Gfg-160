/*
Given an array arr[] of n sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.

Examples:

Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
Explanation:
The arr[] has 4 sorted linked list of size 3, 2, 2, 2.
1st list: 1 -> 2-> 3
2nd list: 4 -> 5
3rd list: 5 -> 6
4th list: 7 -> 8

 
Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation:
The arr[] has 3 sorted linked list of size 2, 3, 1.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6

*/

class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}

// arr is an array of Nodes of the heads of linked lists

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(Node node: arr){
            Node temp=node;
            while(temp!=null){
                minheap.add(temp.data);
                temp=temp.next;
            }
        }
        Node head=new Node(minheap.poll());
        Node temp=head;
        while(!minheap.isEmpty()){
            temp.next=new Node(minheap.poll());
            temp=temp.next;
        }
        return head;
        
    }
}

//Final Time Complexity : O(KNlog(KN))+O(KNlog(KN))=O(KNlog(KN))
//Final Space Complexity : O(KN)+O(KN)=O(KN)
