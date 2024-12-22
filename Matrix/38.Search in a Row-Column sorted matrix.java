/*
Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

Examples:

Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
Output: false
Explanation: 62 is not present in the matrix, so output is false.
Input: mat[][] = [[18, 21, 27],[38, 55, 67]], x = 55
Output: true
Explanation: 55 is present in the matrix.
Input: mat[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]], x = 3
Output: true
Explanation: 3 is present in the matrix.
*/
//[Naive Approach] Comparing with all elements – O(n*m) Time and O(1) Space
class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int n = mat.length, m = mat[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == x)
                    return true;
            }
        }
        return false;
    }
}

//[Expected Approach] Eliminating rows or columns – O(n + m) Time and O(1) Space
class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int n=mat.length,m=mat[0].length;
        int i=0,j=m-1;
        while(i<n && j>=0){
            if(mat[i][j]<x){
                i++;
            }
            else if(mat[i][j]>x){
                j--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
