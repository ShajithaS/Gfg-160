/*
Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

Examples:

Input: mat[][] = [[1, 2, 3],
                [4, 5, 6]
                [7, 8, 9]]
Output: Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]
Input: mat[][] = [[1, 2],
                [3, 4]]
Output: Rotated Matrix:
[2, 4]
[1, 3]
*/
//Naive approach: Using extra matrix , O(n^2) Time and O(n^2) Space
static void rotateMatrix(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];

        // Rotate the matrix 90 degrees counterclockwise
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[n - j - 1][i] = mat[i][j];
            }
        }

        // Copy the rotated matrix back to the original matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(res[i], 0, mat[i], 0, n);
        }
    }

//Optimised, first reverse the elements in each row and the transpose , O(n^2) Time and O(1) Space
static void rotateby90(int mat[][]) {
        // code here
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = 0;
                temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
