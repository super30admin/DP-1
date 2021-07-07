// Recursive method
// Time Complexity : O(2^n); n -> no. of houses
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, Time limit Exceeded due to recursive approach
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I have 2 choices to consider: To rob the current house or not to rob the current house
 * If I choose to rob the current house, then I will not rob the adjacent house, hence I'll move to index+2 position.
 * If I choose not to rob the current house, then I will rob the adjacent house, hence I'll move to index+1 position.
 */

class HouseRobber {
    public int rob(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int amount) {
        //base case
        if(index >= nums.length) {
            return amount;
        }
        
        //logic
        //case1: choose current house for robbing
        int amount1 = helper(nums, index+2, amount+nums[index]);
        
        //case2: do not choose current house
        int amount2 = helper(nums, index+1, amount);
        return Math.max(amount1, amount2);
    }
}


//Tabulation method
//Time Complexity : O(n); n -> no. of houses
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
/*
* I have 2 choices to consider: To rob the current house or not to rob the current house
* If I choose to rob the current house, then I will add the current house's amount to the amount I got by skipping previous house.
* If I choose not to rob the current house, then my current amount will be maximum of the amount I got by either choosing previous house
* or by choosing the adjacent of previous house.
*/

class HouseRobber2 {
    public int rob(int[] nums) {
        // edge case
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length+1][2]; // 2nd dimension accounts for whether I skip the house or choose it
        for(int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);//skip current house
            dp[i][1] += dp[i-1][0] + nums[i-1]; //choose current house
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}