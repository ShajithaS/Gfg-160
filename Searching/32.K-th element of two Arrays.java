/*
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.
Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.
*/

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int x = a.length, y = b.length;
        int[] arr = new int[x+ y];
        int i = 0, j = 0, n = 0;

        while (i < x && j < y) {
            if (a[i] < b[j]) {
                arr[n++] = a[i++];
            }
            else {
                arr[n++] = b[j++];
            }
        }
        while (i < x) {
            arr[n++] = a[i++];
        }
        while (j < y) {
            arr[n++] = b[j++];
        }

        return arr[k - 1];
    }
}