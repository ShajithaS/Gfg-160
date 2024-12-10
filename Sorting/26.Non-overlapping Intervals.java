/*
Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Examples:

Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
Output: 1
Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.
Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
Output: 2
Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.
Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
Output: 0
Explanation: All ranges are already non overlapping.
*/
class Solution {
    static int minRemoval(int intervals[][]) {
        //Sort based on ending interval
        //counting the maximum number of non-overlapping intervals
        //result is obtained by subtracting this count from the total number of intervals.
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt=1;
        int n=intervals.length;
        int prev=intervals[0][1];
        for(int i=1;i<n;i++){
            if(prev<=intervals[i][0]){
                cnt++;
                prev=intervals[i][1];
            }
        }
        return n-cnt;
    }
}
