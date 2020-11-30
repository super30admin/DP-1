// Time Complexity :O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : NA

// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        int rob = 0; 
        int noRob = 0;
        // For every number in array
        for(int n: nums){
            //put rob in a temp variable
            int temp = rob;
            // basically adding the integers
            rob = noRob + n;
            // sum of the variable and the incoming variable
            noRob = Math.max(noRob, temp);
        }
        return Math.max(rob, noRob);
    }
}