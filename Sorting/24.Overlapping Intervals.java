/*
Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].
Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].
*/
class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here 
        int n = arr.length; 
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          // If the list is empty or the current interval doesn't overlap with the last one
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(arr[i]);
            }
          // Merge intervals
            else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }
        return ans;
    }
}
