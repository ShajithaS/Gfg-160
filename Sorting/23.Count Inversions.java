/*Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4
*/
//naive approach , TC:O(n^2)
class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j])
                cnt++;
            }
        }
        return cnt;
    }
}


//[Expected Approach] Using Merge Step of Merge Sort – O(n*log n) Time and O(n) Space
class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);  
    }
    private static int merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int index = 0;
        int cnt = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
                cnt += (mid - left + 1);
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= high) {
            temp[index++] = arr[right++];
        }
        System.arraycopy(temp, 0, arr, low, high - low + 1);
        return cnt;
    }
    private static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            cnt += mergeSort(arr, low, mid);
            cnt += mergeSort(arr, mid + 1, high);
            cnt += merge(arr, low, mid, high);
        }
        return cnt;
    }
}
