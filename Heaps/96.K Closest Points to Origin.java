/*
Given an array of points where each point is represented as points[i] = [xi, yi] on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance, defined as: 

sqrt( (x2 - x1)2 + (y2 - y1)2 )

Note: You can return the k closest points in any order, driver code will sort them before printing.

Examples:

Input: k = 2, points[] = [[1, 3], [-2, 2], [5, 8], [0, 1]]
Output: [[-2, 2], [0, 1]]
Explanation: The Euclidean distances from the origin are:
Point (1, 3) = sqrt(10)
Point (-2, 2) = sqrt(8)
Point (5, 8) = sqrt(89)
Point (0, 1) = sqrt(1)
The two closest points to the origin are [-2, 2] and [0, 1].
Input: k = 1, points = [[2, 4], [-1, -1], [0, 0]]
Output: [[0, 0]]
Explanation: The Euclidean distances from the origin are:
Point (2, 4) = sqrt(20)
Point (-1, -1) = sqrt(2)
Point (0, 0) = sqrt(0)
The closest point to origin is (0, 0).
  */

class Solution {
    public int[][] kClosest(int[][] points, int k) { 
        // Your code here
        PriorityQueue<int[]> maxheap=new PriorityQueue<>((p1,p2) -> (p2[0]*p2[0] + p2[1]*p2[1]) - (p1[0]*p1[0] + p1[1]*p1[1]));
        for(int[] point: points){
            if(maxheap.size()<k){
                maxheap.add(point);
            }
            else{
                int[] top=maxheap.peek();
                if((point[0]*point[0] + point[1]*point[1]) < (top[0]*top[0] + top[1]*top[1]) ){
                    maxheap.poll();
                    maxheap.add(point);
                }
            }
        }
            int res[][]=new int[k][2];
            int i=0;
            while(!maxheap.isEmpty()){
                int[] point=maxheap.poll();
                res[i][0]=point[0];
                res[i][1]=point[1];
                i++;
            }
            return res;
        
    }
}

//Using Priority Queue (Max-Heap) – O(n*log k) Time and O(k) Space
