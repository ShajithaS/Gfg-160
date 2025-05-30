/*
Given an array arr[] of positive integers and an integer k, Your task is to return k largest elements in decreasing order. 

Examples:

Input: arr[] = [12, 5, 787, 1, 23], k = 2
Output: [787, 23]
Explanation: 1st largest element in the array is 787 and second largest is 23.
Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3 
Output: [50, 30, 23]
Explanation: Three Largest elements in the array are 50, 30 and 23.
Input: arr[] = [12, 23], k = 1
Output: [23]
Explanation: 1st Largest element in the array is 23.
  */
public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minheap.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            minheap.add(arr[i]);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(minheap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
