// Time Complexity :O(n) --> beacuse of for loop
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understood easily after solving coin change problem


// Your code here along with comments explaining your approach
public class HouseRobber {
    
    public static void main(String[] args) {
        int[] nums = new int[]{6, 7, 1, 3, 8, 2, 4};
        System.out.println(rob(nums));
       // System.out.println(houseRobber(nums));
    }
    public static int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2;i<dp.length;i++)
            //choose dp[i-1] if you want to skip current house , else if you want to choose current house then you need to skip previous house and add the amount robbed at i-2 house ,so nums[i-1]+dp[i-2]
            dp[i] = Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        //dp array last value will be the maximum amount a robber can rob 
        return dp[nums.length];

    }
}
