//Minimize the Heights II
class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
        int n=arr.length;
        Arrays.sort(arr);
        int result = arr[n - 1] - arr[0];
        int minHeight, maxHeight;
        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) 
                continue;
            minHeight = Math.min(arr[0] + k, arr[i] - k);
            maxHeight = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            result = Math.min(result, maxHeight - minHeight);
        }
        return result;
    }
}
