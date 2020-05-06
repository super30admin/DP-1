// Time Complexity : O(n) where n is the length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        int rob=0,notRob=0,prevNotRob=0;
        for(int n:nums){
            prevNotRob = notRob;
            notRob = Math.max(rob,notRob);
            rob=prevNotRob+n;
        }
        
        return Math.max(rob,notRob);
    }
}