/*
//  Time Complextiy : O(n) where n is the elemenents of the dp array.
//  Space Complextiy : O(n) where n is length of the dp array.
 // Did this code successfully run on Leetcode : Yes, worked on the leetcode
 // Any problem you faced while coding this : No
*/


public class Solution_Housh {
    
        public int rob(int[] nums) {
            // checking null elements

            if(nums.length == 0) return -1;
        
            int dp[] = new int[nums.length+2];
            
            dp[0] = 0;
            dp[1] = 0;
            // iterting throught the array
            for(int i = 2; i<dp.length; i++) {
                // checking choose and not choose case.
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-2]);
            }
            // returning the last element of the array.
            return dp[dp.length-1];
            
        }
        
    
}
