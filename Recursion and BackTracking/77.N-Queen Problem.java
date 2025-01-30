/*
The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent
a distinct board configuration of the queen placements, where the solutions 
are represented as permutations of [1, 2, 3, ..., n]. In this representation, 
the number in the ith position denotes the row in which the queen is placed in the ith column.
Input: n = 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.
Input: n = 4
Output: [[2 4 1 3 ] [3 1 4 2 ]]
Explaination: There are 2 possible solutions for n = 4.
Input: n = 2
Output: []
Explaination: There are no possible solutions for n = 2.
*/
class Solution {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        int board[][]=new int[n][n];
        int rows[]=new int[n+1];
        int cols[]=new int[n+1];
        int nw[]=new int[(2*n)-1];
        int sw[]=new int[(2*n)-1];
        place(n,board,rows,cols,nw,sw,0);
        return ans;
    }
    private void place(int n,int[][] board,int[] rows,int[] cols,int[] nw,int[]sw,int row){
        if(row==n){
            add(board,n);
            return;
        }
        for(int col=0;col<n;col++){
            if(rows[row]==0 && cols[col]==0 &&  nw[row+col]==0 && sw[(col-row)+(n-1)]==0 ){
                rows[row]=1;
                cols[col]=1;
                nw[row+col]=1;
                sw[col-row+n-1]=1;
                board[row][col]=1;
                place(n,board,rows,cols,nw,sw,row+1);
                rows[row]=0;
                cols[col]=0;
                nw[row+col]=0;
                sw[col-row+n-1]=0;
                board[row][col]=0;
            }
        }
    }
    private void add(int[][] board,int n){
        ArrayList<Integer> colidx=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    colidx.add(j+1);
                    break;
                }
            }
        }
        ans.add(colidx);
    }
}
//Time complexity:Worst case: O(N!) (factorial complexity).
//Auxiliary Space : O(n)
