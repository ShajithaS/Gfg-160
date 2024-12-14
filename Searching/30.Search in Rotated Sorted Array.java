/*
Given a sorted and rotated array arr[] of distinct elements, the task is to find the index of a target key. Return -1 if the key is not found.

Examples :

Input: arr[] = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3
Output: 8
Explanation: 3 is found at index 8.
Input: arr[] = [3, 5, 1, 2], key = 6
Output: -1
Explanation: There is no element that has value 6.
Input: arr[] = [33, 42, 72, 99], key = 42
Output: 1
Explanation: 42 is found at index 1.
*/
class Solution {
    int search(int[] arr, int key) {
        // Complete this function
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] >= arr[lo]) {
                if (key >= arr[lo] && key < arr[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else {
                if (key > arr[mid] && key <= arr[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1; 
    }
}
