/*
You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

Examples :

Input: mat[][] = [['T', 'E', 'E'],
                  ['S', 'G', 'K'],
                  ['T', 'E', 'L']],
                  word = "GEEK"
Output: true

Input: mat[][] = [['T', 'E', 'U'],
                  ['S', 'G', 'K'],
                  ['T', 'E', 'L']],
                  word = "GEEK"
Output: false
Input: mat[][] = [['A', 'B', 'A'],
                  ['B', 'A', 'B']],
                  word = "AB"
Output: true

  */

class Solution {
    static int found=0;
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int R=mat.length;
        int C=mat[0].length;
         for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==word.charAt(0)){
                    if(search(mat,word,i,j,0,R,C))
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean search(char[][] mat, String word,int row,int col,int index,int R,int C){
        
            if(index==word.length()){
                return true;
            }
            if(row < 0 || row >= R || col< 0 || col>=C || mat[row][col]!=word.charAt(index)){
                return false;
            }
            char backup=mat[row][col];
            mat[row][col]='-';
            boolean found=(
            search(mat,word,row+1,col,index+1,R,C)||
            search(mat,word,row-1,col,index+1,R,C)||
            search(mat,word,row,col+1,index+1,R,C)||
            search(mat,word,row,col-1,index+1,R,C)
            );
            mat[row][col]=backup;
            return found;
        
    }
}
//Time Complexity: O(R × C × 4^L) (where L is the length of the word)
//Space Complexity: O(L) (recursion depth at most L)
