
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rob(int[] nums) {
        
        //either we can choose or not choose to rob a house
        int choose = 0;
        int dont_choose = 0;
        
        //iterate over that nums array 
        for(int i = 0; i < nums.length; i++){
            //temp variable to store the previous dont_choose value as it keeps getting updated and we want to keep track of the last dont_choose value
            int temp = dont_choose;
            
            //dont_choose would be the max of choose and dont_choose
            dont_choose = Math.max(choose, dont_choose);
            //if we choose the current index, we cannot choose the previous index so add current value to the dont_choose value of the previous index which we stored in the temp variable
            choose = temp + nums[i];
            
        }
        //finally return the max between choose and dont_choose
        return Math.max(choose, dont_choose);
    }
}