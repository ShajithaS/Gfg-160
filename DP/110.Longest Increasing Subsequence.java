/*
Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
Input: arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output: 6
Explanation: One of the possible longest strictly increasing subsequences is [0, 2, 6, 9, 13, 15], which has a length of 6.
Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
*/
class Solution {
    static int lis(int arr[]) {
        // code here
        int n=arr.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        return fun(0,-1,arr,n,dp);
    }
    static int fun(int ind,int prev_ind,int[] arr,int n,int[][] dp){
        if(ind==n)
        return 0;
        if(dp[ind][prev_ind+1]!=-1)
        return dp[ind][prev_ind+1];
        int len=0+fun(ind+1,prev_ind,arr,n,dp);
        if(prev_ind==-1 || arr[ind]>arr[prev_ind]){
            len=Math.max(len,1+fun(ind+1,ind,arr,n,dp));
        }
        dp[ind][prev_ind+1]=len;
        return len;
    }
}

/*
Time Complexity: O(N*N)

Reason: There are N*N states therefore at max ‘N*N’ new problems will be solved.

Space Complexity: O(N*N) + O(N)

Reason: We are using an auxiliary recursion stack space(O(N)) (see the recursive tree, in the worst case we will go till N calls at a time) and a 2D array ( O(N*N+1)).
*/
