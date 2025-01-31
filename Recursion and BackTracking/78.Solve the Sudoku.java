/*
Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.
  */

//Approach 1 : Time linit exceeded
class Slot{
    int r,c;
}
class Solution {
    static int R=9;
    static int C=9;
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat);
    }
    static boolean solve(int[][] mat){
        Slot slot=getfreeslot(mat);
        if(slot==null)
        return true;
        for(int digit=1;digit<=9;digit++){
            if(canfillrow(mat,slot,digit) && canfillcol(mat,slot,digit) && canfillsubmat(mat,slot,digit)){
            mat[slot.r][slot.c]=digit;
            if(solve(mat)){
            return true;
            }
            mat[slot.r][slot.c]=0;
        }
        }
        return false;
    }
    private static Slot getfreeslot(int[][] mat){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(mat[i][j]==0){
                    Slot slot=new Slot();
                    slot.r=i;
                    slot.c=j;
                    return slot;
                }
            }
        }
        return null;
    }
    private static boolean canfillrow(int[][] mat, Slot slot, int digit){
        for(int col=0;col<C;col++){
            if(mat[slot.r][col]==digit){
                return false;
            }
        }
        return true;
    }
    private static boolean canfillcol(int[][] mat, Slot slot, int digit){
        for(int row=0;row<R;row++){
            if(mat[row][slot.c]==digit){
                return false;
            }
        }
        return true;
    }
    private static boolean canfillsubmat(int[][] mat, Slot slot, int digit){
        int startrow=(slot.r/3)*3;
        int startcol=(slot.c/3)*3;
        for(int row=startrow;row<startrow+3;row++){
            for(int col=startcol;col<startcol+3;col++){
                if(mat[row][col]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    
}

//Approach 2:
class Solution {
    static int n=9;
    static boolean[][] rowused=new boolean[n][n+1];
    static boolean[][] colused=new boolean[n][n+1];
    static boolean[][] submatused=new boolean[n][n+1];
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        initialize(mat);
        solve(mat,0,0);

    }
    private static void initialize(int[][] mat){
        for(int i=0;i<n;i++){
            Arrays.fill(rowused[i],false);
            Arrays.fill(colused[i],false);
            Arrays.fill(submatused[i],false);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=mat[i][j];
                if(num!=0){
                    rowused[i][num]=true;
                    colused[j][num]=true;
                    submatused[(i/3)*3+(j/3)][num]=true;
                }
            }
        }
    }
    private static boolean solve(int[][] mat,int r, int c){
        if(r==n)
        return true;
        if(c==n){
            return solve(mat,r+1,0);
        }
        if(mat[r][c]!=0){
            return solve(mat,r,c+1);
        }
        for(int digit=1;digit<=9;digit++){
            if(!rowused[r][digit] && !colused[c][digit] && !submatused[(r/3)*3+(c/3)][digit]){
                mat[r][c]=digit;
                rowused[r][digit]=true;
                colused[c][digit]=true;
                submatused[(r/3)*3+(c/3)][digit]=true;
                if(solve(mat,r,c+1))
                return true;
                mat[r][c]=0;
                rowused[r][digit]=false;
                colused[c][digit]=false;
                submatused[(r/3)*3+(c/3)][digit]=false;
            }
        }
        return false;
    }
    
    
}
/*
   Case	          Time Complexity	    Space Complexity
Worst Case	   O(9^k) (Exponential)	      O(1)
Average Case	   O(9^k) with pruning	    O(1)
Best Case      	O(1) (Already solved)    	O(1)
*/


