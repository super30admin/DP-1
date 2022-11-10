/*
    Time Complexity = O(N) //n variable houses, two fixed columns
    Space Complexity = O(N) //n variable houses, two fixed columns
    Did this code successfully run on Leetcode : yes
*/

package com.madhurima;

public class HouseRobber {
}

class SolutionA {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        /*
            col0 = given house not robbed
            col1 = given house robbed
            0th row fill manually
            from 1st row:
            if not robbed, keep amount as max collected untill now
            if robbed, previous house not robbed -> pick amount from previous house's not robbed case and add current house's value to it
            at the end -> return max of last row
        */


        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][1] = nums[0];

        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);


        // return helper(nums, 0, 0);
    }


    //Recursive function
    //Time Complexity = Exponential, running into Time Limit Exceeded exception
    private int helper(int[] nums, int index, int amountRobbed){
        //base
        if(index >= nums.length){
            return amountRobbed;
        }

        //logic
        //case1: given house not robbed
        int case1 = helper(nums, index+1, amountRobbed);

        //case2: given house robbed
        int case2 = helper(nums, index+2, amountRobbed+nums[index]);

        return Math.max(case1, case2);

    }

    public static void main(String[] args) {
        SolutionA s= new SolutionA();
        int[] nums = {2,7,9,3,1};
        System.out.println(s.rob(nums));
    }


}
