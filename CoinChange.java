// Time Complexity : O(amount*no of coins)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
//I am using DP to solve this, like updating all the mininmum 
//number of coins required for a specific amount size, and slowly 
//increamenting the amount size until i reach the target amount;
class Solution {
    public int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        // logic
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, amount + 1);
        amounts[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if ((i - coin) >= 0) {
                    amounts[i] = Math.min(amounts[i], amounts[i - coin] + 1);
                }
            }
        }
        return amounts[amount] == amount + 1 ? -1 : amounts[amount];
    }
}