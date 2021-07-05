// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int rob(int[] nums) {
        //base case to check in case the array is empty
        if(nums == null || nums.length == 0)
            return 0;
        
        //If there is only one house then that is the only one to rob from
        if(nums.length == 1)
            return nums[0];
        
        //either we choose and add the money or we don't choose and start with 0
        int choose = nums[0];
        int skip = 0;
        
        //loop through all the houses
        for(int i = 1; i < nums.length; i++){
            //temp var to hold the value of skip
            int prevSkip = skip;
            //the new skip shall be the max between the previous two values
            skip = Math.max(skip, choose);
            //if you choose then you start with the previously skipped value and add the newly chosen house 
            choose = prevSkip + nums[i];
        }
        
        //the max out of both of them is the one we want to return
        return Math.max(skip, choose);
    }
}