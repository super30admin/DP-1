# DP-1

## Problem1 (https://leetcode.com/problems/coin-change/)

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Approach 1: Recursive solution
//Time Complexity 2^n
//Space complexity: Recursion stack
class Solution {
public int coinChange(int[] coins, int amount) {

    int result=0;
    if(amount == 0) return 0;

    int maxValue= Integer.MAX_VALUE;

    for(int i=0;i< coins.length; i++){
    if(coins[i] <= amount) {
    int subResult = coinChange(coins, amount-coins[i]);
    if(subResult != Integer.MAX_VALUE){
        result = Math.min(maxValue, subResult+1);
    }
    }

    }
    return (result == 0) ? -1 : result;

}

}

//Approach 2: DP
class Solution {
public int coinChange(int[] coins, int amount) {

    int result = 0;

    int dp[]= new int[amount + 1];
    Arrays.fill(dp,Integer.MAX_VALUE );
    dp[0] = 0;


    //Traverse through dp array
    for(int i=1; i< dp.length;i++){
        //Traverse through all coins
        for(int j=0; j < coins.length ; j++){
            if(coins[j] <= i){
                int remainder = dp[i- coins[j]];
                if(remainder != Integer.MAX_VALUE){
                dp[i]=Math.min(dp[i], remainder+1);
                }
            }

        }

    }
    return dp[amount] > amount  ? -1 : dp[amount];

    }

}

## Problem2 (https://leetcode.com/problems/house-robber/)

//Time complexity O(n)
//Space Complexity 0(n) for the dp array

class Solution {
public int rob(int[] nums) {
//Basecase
if(nums.length <= 1) return nums.length == 0 ? 0 : nums[0];

        int dp[] =new int[nums.length];

        dp[0] = nums[0];
        //Can rob from the previous house or just continue with the amount at present
        dp[1] =Math.max(nums[0] , nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2] , dp[i-1]);
        }
        return dp[dp.length -1];

    }


}
