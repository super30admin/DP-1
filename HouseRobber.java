/**
 * ## Problem2 (https://leetcode.com/problems/house-robber/)
 
Time Complexity :   O (N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (198. House Robber)
Any problem you faced while coding this :       No
 */

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i =2; i< n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        
        return dp[n-1];
    }

    public static void main(String args[]) 
     { 
        HouseRobber obj = new HouseRobber();
        int[] nums = {1,2,3,1};
        System.out.println(obj.rob(nums));
     }
}
