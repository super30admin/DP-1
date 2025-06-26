// Time Complexity : O(amount * n) where n is coins length
// Space Complexity : O(amount) for the array created
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach - I used an array to maintain a count of minimum coins needed to make up value of particular index.
// At each point - I have 2 choices, incldue a coin -  I find it's previous amounts, if with any coin I see a previous amount that was made and using that + this coin has minimum steps, I update the index. Or not include - let the value be what it was.  
// I return -1 if we cannot make amount, else the index amount from array as it represents the minimum coins.

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length==1 && amount%coins[0]!=0) return -1;
        else if(coins.length==1) return amount/coins[0];
        int [] allAmountMinimums = new int[amount+1];
        Arrays.fill(allAmountMinimums, amount + 1); 
        allAmountMinimums[0]=0;
        for(int i = 1; i<=amount; i++){
            for(int coin : coins){
                if(i-coin<0) continue;
                allAmountMinimums[i] = Math.min(allAmountMinimums[i], 1 + allAmountMinimums[i - coin]);
            }
        }
        return (allAmountMinimums[amount]==amount+1)?-1:allAmountMinimums[amount];
    }
}