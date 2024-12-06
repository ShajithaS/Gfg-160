/*
Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.

H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

Examples:

Input: citations[] = [3, 0, 5, 3, 0]
Output: 3
Explanation: There are at least 3 papers (3, 5, 3) with at least 3 citations.
Input: citations[] = [5, 1, 2, 4, 1]
Output: 2
Explanation: There are 3 papers (with citation counts of 5, 2, and 4) that have 2 or more citations. However, the H-Index cannot be 3 because there aren't 3 papers with 3 or more citations.
Input: citations[] = [0, 0]
Output: 0
*/
/*
Efficient Approach: The idea is to use binary search to optimize the above approach. The H-index can lie in the range from 0 to N. To check if a given value is possible or not, check if citations[value] is greater than or equal to value.

Initialize the search range for the Binary search as 0 to N.
Find the middle element of the range.
Check if the middle element of the citation is less than the index. If so, then update the left range to middle element.
Otherwise, check if the middle element of the citation is greater than the index. If so, then update the right range to the middle element.
Otherwise, the given index is the H-index of the Citations.
*/
class Solution {
    // Function to find hIndex
    public int hIndex(int[] citations) {
        // code here
        int n=citations.length;
        Arrays.sort(citations);
        reverse(citations);
    int ans = 0; //ans is the H index
    int low = 0, high = n - 1;
    while (low <= high) 
    {
        int mid = (low + high) / 2;
        if (citations[mid] >= (mid + 1))
        {
            low = mid + 1;
            ans = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return ans;
    }
    public static void reverse(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
}
