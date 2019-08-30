//Time complexity: O(n)
//Space complexity: O(n)
class Solution {
    public int rob(int[] nums) {
        //if nums has 4 size dp array has 6 size
        int [] dp = new int [nums.length+2];
        //Iterate over dp array
        for(int i =2; i <dp.length; i++)
        {
            //dp[i] is assigned the max of 2 values
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-2]);
        }
        //return the value
        return dp[dp.length-1];
    }
}