/*
Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40

Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20 
*/

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(head==null || k==0)
        return head;
        int len=1;
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
            len++;
        }
        k%=len;
        if(k==0)
        return head;
        
        tail.next=head;
        tail=head;
        for(int i=1;i<k;i++){
            tail=tail.next;
        }
        head=tail.next;
        tail.next=null;
        return head;
    }
}
