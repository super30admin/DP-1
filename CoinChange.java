// Time Complexity : The time complexity is O(mn) where n is the length of the coins array and m is the amount.
// Space Complexity : The space complexity is O(m) where m is the amount.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {

        // Array which stores the minimum number of coins for every amount
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1;i<amount+1;i++){

            int count = Integer.MAX_VALUE;

            // For the minimum number of coins required for making current minimum
            for(int j=0;j<coins.length;j++){

                if(i-coins[j] >= 0){

                    if(dp[i-coins[j]] != -1){
                        int val = dp[i-coins[j]]+1;
                        count = Math.min(count,val);
                    }

                }

            }

            // If it is possible to make the current amount with the given coins, store the minimum number of coins
            if(count != Integer.MAX_VALUE){
                dp[i] = count;
            }
            // If it is not possible to make the current amount with the given coins, store -1
            else{
                dp[i] = -1;
            }

        }

        return dp[amount];

    }
}

// Time Complexity :
// Space Complexity : The space complexity is O(1).
// Did this code successfully run on Leetcode : No(Time Limit Exceeded)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int coinChange(int[] coins, int amount) {

        int output = recursive(coins,amount);
        return output == Integer.MAX_VALUE ? -1 : output;

    }

    public int recursive(int[] coins,int amount){

        // Base case
        if(amount == 0){
            return 0;
        }

        int count = Integer.MAX_VALUE;

        // For the minimum number of coins required for making current minimum
        for(int i=0;i<coins.length;i++){

            if(amount-coins[i] >= 0){
                int val = recursive(coins,amount-coins[i]);

                if(val != Integer.MAX_VALUE){
                    val++;
                }

                // Store the minimum number of coins required for making the current minimum
                count = Math.min(count,val);
            }

        }

        return count;


    }
}