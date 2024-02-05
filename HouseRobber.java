// Time Complexity : O(n) //iterating over entire nums array : Optionation for previous exponential solutions
// Space Complexity : O(n) // Creating new array same as nums length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Learning DP. Able to code post watching videos.

/*
At every step of house, we have 2 choice, whether to rob the house or not to rob the house.
Based on that it is maximum of that step of repeated subproblem to find out earning.
Towards the end find maximum earning by picking last element.
*/

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 2) return nums[0]; //Just one element in Array// one house

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i =2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length-1];
    }


    public static void main(String[] args) {
        HouseRobber hr= new HouseRobber();
        int[] nums = {1,3,2,1};
        int result = hr.rob(nums);

        System.out.println("Maximum earning at the end of nth house robbing = " + result);

    }
}