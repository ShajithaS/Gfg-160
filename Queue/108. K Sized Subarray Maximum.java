/*
Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. The output should be an array of maximum values corresponding to each contiguous subarray.

Examples:

Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6] 
Explanation: 
1st contiguous subarray = [1 2 3] max = 3
2nd contiguous subarray = [2 3 1] max = 3
3rd contiguous subarray = [3 1 4] max = 4
4th contiguous subarray = [1 4 5] max = 5
5th contiguous subarray = [4 5 2] max = 5
6th contiguous subarray = [5 2 3] max = 5
7th contiguous subarray = [2 3 6] max = 6
Input: arr[] = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13], k = 4
Output: [10, 10, 10, 15, 15, 90, 90]
Explanation: 
1st contiguous subarray = [8 5 10 7], max = 10
2nd contiguous subarray = [5 10 7 9], max = 10
3rd contiguous subarray = [10 7 9 4], max = 10
4th contiguous subarray = [7 9 4 15], max = 15
5th contiguous subarray = [9 4 15 12], max = 15
6th contiguous subarray = [4 15 12 90], max = 90
7th contiguous subarray = [15 12 90 13], max = 90
Input: arr[] = [5, 1, 3, 4, 2, 6], k = 1
Output: [5, 1, 3, 4, 2, 6]
Explanation: 
When k = 1, each element in the array is its own subarray, so the output is simply the same array

*/

//[Naive Approach] - Using Nested Loops - O(n * k) Time and O(1) Space
import java.util.ArrayList;
import java.util.*;

class GfG {

    // Method to find the maximum for each
    // and every contiguous subarray of size k.
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int n = arr.length;

        // to store the results
        ArrayList<Integer> res = new ArrayList<Integer>();
      
        for (int i = 0; i <= n - k; i++) {
      
            // Find maximum of subarray beginning
            // with arr[i]
            int max = arr[i];
            for (int j = 1; j < k; j++) {
                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            res.add(max);
        }
      
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        ArrayList<Integer> res = maxOfSubarrays(arr, k);
        for (int maxVal : res) {
            System.out.print(maxVal + " ");
        }
    }
}

//[Better Approach] - Using Max-Heap - (n * log n) Time and O(n) Space
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class GfG {

    // Method to find the maximum for each
    // and every contiguous subarray of size k.
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int n = arr.length;

        // to store the results
        ArrayList<Integer> res = new ArrayList<Integer>();

        // to store the max value
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.first - a.first;
            }
        });

        // Initialize the heap with the first k elements
        for (int i = 0; i < k; i++)
            heap.add(new Pair(arr[i], i));

        // The maximum element in the first window
        res.add(heap.peek().first);

        // Process the remaining elements
        for (int i = k; i < arr.length; i++) {

            // Add the current element to the heap
            heap.add(new Pair(arr[i], i));

            // Remove elements that are outside the current
            // window
            while (heap.peek().second <= i - k)
                heap.poll();

            // The maximum element in the current window
            res.add(heap.peek().first);
        }

        return res;
    }

    static class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        ArrayList<Integer> res = maxOfSubarrays(arr, k);
        for (int maxVal : res) {
            System.out.print(maxVal + " ");
        }
    }
}

//[Expected Approach] - Using Deque - O(n) Time and O(k) Space
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

class GfG {

    // Method to find the maximum for each
    // and every contiguous subarray of size k.
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int n = arr.length;

        // to store the results
        ArrayList<Integer> res = new ArrayList<Integer>();

        // create deque to store max values
        Deque<Integer> dq = new ArrayDeque<Integer>();

        // Process first k (or first window) elements of array
        for (int i = 0; i < k; ++i) {
          
            // For every element, the previous smaller elements 
            // are useless so remove them from dq
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
              
                // Remove from rear
                dq.pollLast();
            }

            // Add new element at rear of queue
            dq.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (int i = k; i < arr.length; ++i) {
          
            // The element at the front of the queue is the largest 
            // element of previous window, so store it
            res.add(arr[dq.peekFirst()]);

            // Remove the elements which are out of this window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
              
                // Remove from front of queue
                dq.pollFirst();
            }

            // Remove all elements smaller than the currently being 
            // added element (remove useless elements)
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }

            // Add current element at the rear of dq
            dq.addLast(i);
        }

        // store the maximum element of last window
        res.add(arr[dq.peekFirst()]);

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 7, 3};
        int k = 3;
        ArrayList<Integer> res = maxOfSubarrays(arr, k);
        for (int maxVal : res) {
            System.out.print(maxVal + " ");
        }
    }
}

