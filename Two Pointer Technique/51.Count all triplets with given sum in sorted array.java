/*
Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1. 
*/
//Using two pointer technique , Time Complexity: O(n2) Auxiliary Space: O(1)

public int countTriplets(int[] arr, int target) {
        // Code Here
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n-2;i++){
            int l=i+1,r=n-1;
            int required=target-arr[i];
            while(l<r){
                if(arr[l]+arr[r]<required)
                l++;
                else if(arr[l]+arr[r]>required)
                r--;
                else if(arr[l]+arr[r]==required){
                    int ele1=arr[l],ele2=arr[r];
                    int cnt1=0,cnt2=0;
                    while(l<=r && arr[l]==ele1){
                        l++;
                        cnt1++;
                    }
                    while(l<=r && arr[r]==ele2){
                        r--;
                        cnt2++;
                    }
                    if(ele1==ele2){
                        cnt+=(cnt1*(cnt1-1))/2;
                    }
                    else{
                        cnt+=(cnt1*cnt2);
                    }
                }
            }
        }
        return cnt;
    }
