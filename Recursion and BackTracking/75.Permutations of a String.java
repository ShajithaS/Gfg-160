/*
Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.
Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.
Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.
*/

class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> list=new ArrayList<>();
        StringBuilder str=new StringBuilder(s);
        HashSet<String> set=new HashSet<>();
        stringpermute(str,set,0);
        list.addAll(set);
        return list;
    }
    void stringpermute(StringBuilder str,HashSet<String> set,int idx){
        if(idx==str.length()-1){
            set.add(str.toString());
            return;
        }
        for(int i=idx;i<str.length();i++){
            swap(str,idx,i);
            stringpermute(str,set,idx+1);
            swap(str,idx,i);
        }
    }
    void swap(StringBuilder s,int i,int j){
        char temp=s.charAt(i);
        s.setCharAt(i,s.charAt(j));
        s.setCharAt(j,temp);
    }
}

//Time Complexity: O(n×n!)   Generating all permutations takes O(n!), where n is the length of the string.For each permutation, adding to the HashSet takes O(1) on average.
// Space Complexity: O(n+n!). O(n) for the recursion stack (depth of recursion tree). O(n!) for storing the permutations in the HashSet
