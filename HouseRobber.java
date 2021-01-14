// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class HouseRobber {
	public int rob(int[] nums) {
        int dp[] = new int[nums.length+2];
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1],nums[i-2]+dp[i-2]);
        }
    return dp[dp.length-1];
    }
	
    public int rob1(int[] nums) {
        return helper(nums,0,false,0);
    }
    public int helper(int[] nums, int index, boolean lastHouseRobbed, int amount){
        if(index == nums.length){return amount;}
        int maxAmount = 0;
        if(!lastHouseRobbed){
            maxAmount = Math.max(maxAmount,helper(nums,index+1,true,amount+nums[index]));
        }
        maxAmount = Math.max(maxAmount,helper(nums,index+1,false,amount));
    return maxAmount;
    }
}