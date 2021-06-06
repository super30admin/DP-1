//Time Complexity :  O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int rob(int[] num) {
     int prevNo = 0;
     int prevYes = 0;
     for (int n : num) {
         int temp = prevNo;
         prevNo = Math.max(prevNo, prevYes);
         prevYes = n + temp;
     }
     return Math.max(prevNo, prevYes);
 }
 }