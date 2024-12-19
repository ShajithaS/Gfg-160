/*
Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

Examples :

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 5, 6… and 2nd missing number is 2.
*/
//naive approach u
sing Hash Set – O(n) Time and O(n) Space
class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int count = 0, curr = 0;
        while (count < k) {
            curr++;
            if (!set.contains(curr)) {
                count++;
            }
        }
        return curr;
    }
}



//better  O(n) Time and O(1) Space
static int kthMissing(int[] arr, int k) {
      
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > (k + i)) {
                return (k + i);
            }
        }
      
        // If all numbers from 1 to n are present 
        // in arr[], return k + n
        return k + n;
    }




//optimise approach Using Binary Search – O(log n) Time and O(1) Space
static int kthMissing(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        int res = arr.length + k;

        // Binary Search for index where arr[i] > (i + k)
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > mid + k) {
                res = mid + k;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return res;
    }
