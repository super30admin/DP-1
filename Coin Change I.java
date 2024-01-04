// Time Complexity : O(coins*amount)
// Space Complexity :O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {

        if(coins.length == 0) return -1;
        if(amount == 0) return 0;

        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];

        // Initialize first row will Integer.MAX_VALUE;
        Arrays.fill(prev, Integer.MAX_VALUE);

        for(int i = 0; i < coins.length; i++){
            int coinValue = coins[i];
            for(int amountValue = 1; amountValue < curr.length; amountValue++){
                int without = prev[amountValue];
                int remainingValue = amountValue - coinValue;
                int with;
                if(remainingValue > -1 && curr[remainingValue] < Integer.MAX_VALUE){
                    with = curr[remainingValue] + 1;
                } else with = Integer.MAX_VALUE;
                curr[amountValue] = Math.min(with, without);
            }
            prev = curr;
            curr = new int[amount+1];
        }

        return prev[amount] == Integer.MAX_VALUE ? -1: prev[amount];
    }
}
