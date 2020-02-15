//Recursive solution with memoization
// Time Complexity : O(m*2^n); m -> amount; n -> no. of coins
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : No, the recursive solution works fine with TLE. However, for memoized solution, only
// 												116/182 test cases passed.  
// Any problem you faced while coding this : Recursive approach with memoized version did not work as expected. 
//											 Please check the code below and let me know the issue


// Your code here along with comments explaining your approach
/*
 * In this problem at any point of time, we can make two decisions. Either to choose the current coin or not choose the current coin. 
 * If we are selecting the current coin, then the denomination is subtracted from amount. Otherwise, we'll move to the next coin and again 
 * consider the two cases.
 * I tried to capture the repeating subproblems in a memo array wherein if we have already encountered a particular index with a particular
 * coin, we need not recompute. We can reuse the previously computed value.
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] memo = new int[coins.length][amount+1]; // for memoization
        return helper(coins, amount, 0, 0, memo);
    }
    
    private int helper(int[] coins, int amount, int index, int result, int[][] memo) {
        //Base case
        if(amount == 0) {
            return result;
        }
        if(index > coins.length-1 || amount < 0) {
            return -1;
        }
        
        // Check if calculations at this index for the given amount is already stored
        if(memo[index][amount] > 0) { // if already seen this pattern, no need to compute again
            return memo[index][amount];
        }
        
        // Do not choose a coin
        int count1 = helper(coins, amount, index+1, result, memo);
        
        //Choose a coin
        int count2 = helper(coins, amount - coins[index], index, result+1, memo);
        if(count1 == -1) {
            return count2;
        }
        if(count2 == -1) {
            return count1;
        }
        memo[index][amount] = Math.min(count1, count2);
        return memo[index][amount];
    }
}