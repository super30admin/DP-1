// Time Complexity : O(n), where n is the number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problems faced while coding this: // Initially , I used a 1-D array and searched for the maximum before updating 
                                        //  the robbed house with the previous max value. Which lead TLE.

// Approach:

// This solution uses dynamic programming with two variables
        // r (money if robbing current house) and nr (money if skipping it).  
// At each step, update r as nr + nums[i] and nr as the max of previous r and nr.  
// Finally, return the max of r and nr to get the maximum amount that can be robbed.

class solution {
    public int rob(int[] nums) {
        int nr = 0;
        int r = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int temp = r;
            r = nr+nums[i];
            nr = Math.max(temp,nr);
        }
        return Math.max(nr,r);
    }
}