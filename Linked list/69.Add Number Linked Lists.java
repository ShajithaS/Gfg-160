/*
Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0
 
Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7 
Output: 7 -> 0 
 
Explanation: Given numbers are 63 and 7. There sum is 70.
*/
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
class Solution {
    
        // code here
    Node reverse(Node head){
            Node prev=null;
            Node curr=head;
            while(curr!=null){
                Node next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            return prev;
    }
        Node addTwoLists(Node l1, Node l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        Node dummy=new Node(0);
        Node tail=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=carry;
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }
            carry=sum/10;
            tail.next=new Node(sum%10);
            tail=tail.next;
        }
        Node res=reverse(dummy.next);
        while(res!=null && res.data==0 && res.next!=null){
            res=res.next;
        }
        return res;
    }
}

//Time Complexity: O(max(n, m)), where n and m are the lengths of the input linked lists. Each list is traversed multiple times: once for reversing and once for summing.
//Space Complexity: O(1), as no extra space proportional to the size of the input is used; only a constant amount of additional space is required.
