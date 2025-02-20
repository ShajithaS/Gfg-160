/*
Given a data stream arr[] where integers are read sequentially, the task is to determine the median of the elements encountered so far after each new integer is read.

There are two cases for median on the basis of data set size.

1. If the data set has an odd number then the middle one will be consider as median.
2. If the data set has an even number then there is no distinct middle value and the median will be the arithmetic mean of the two middle values.

Examples:

Input:  arr[] = [5, 15, 1, 3, 2, 8]
Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0] 
Explanation: 
After reading 1st element of stream – 5 -> median = 5.0
After reading 2nd element of stream – 5, 15 -> median = (5+15)/2 = 10.0 
After reading 3rd element of stream – 5, 15, 1 -> median = 5.0
After reading 4th element of stream – 5, 15, 1, 3 ->  median = (3+5)/2 = 4.0
After reading 5th element of stream – 5, 15, 1, 3, 2 -> median = 3.0
After reading 6th element of stream – 5, 15, 1, 3, 2, 8 ->  median = (3+5)/2 = 4.0
Input: arr[] = [2, 2, 2, 2]
Output: [2.0, 2.0, 2.0, 2.0]
Explanation: 
After reading 1st element of stream – 2 -> median = 2.0
After reading 2nd element of stream – 2, 2 -> median = (2+2)/2 = 2.0
After reading 3rd element of stream – 2, 2, 2 -> median = 2.0
After reading 4th element of stream – 2, 2, 2, 2 ->  median = (2+2)/2 = 2.0
*/

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> ans=new ArrayList<>();
        PriorityQueue<Integer> leftmaxheap=new PriorityQueue<>((a,b)->(b-a));
        PriorityQueue<Integer> rightminheap=new PriorityQueue<>();
        for(int num:arr){
            leftmaxheap.add(num);
            rightminheap.add(leftmaxheap.poll());
            if(rightminheap.size()>leftmaxheap.size()){
                leftmaxheap.add(rightminheap.poll());
            }
            if(rightminheap.size()==leftmaxheap.size()){
                ans.add((leftmaxheap.peek()+rightminheap.peek())/2.0);
            }
            else{
                ans.add ((double)leftmaxheap.peek());
            }
        }
        return (ans);
    }
}

//Time Complexity: O(NlogN)
//Space Complexity: O(N)
