/*
Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

Examples:

Input: arr[] = [0, 1, 2, 0, 1, 2]
Output: [0, 0, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
Explanation: 0s 1s and 2s are segregated into ascending order.
*/

//Approach:Dutch National flag Algorithm

public void sort012(int[] arr) {
        // code here
        int n=arr.length;
        int mid=0,low=0;
        int high=n-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp0 = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp0;
                mid++;
                low++;
            }

            else if(arr[mid]==1){
                mid++;
            }

            else
            {
                int temp2 = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp2;
                high--;
            }
        }
    }
