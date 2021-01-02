// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinChange{

    private int coinChange(int coins,int amount){
        if (coins == null || coins.length == 0) return -1;

        //we want 0 as one of the possibility hence coins.length+1, and amount+1 as the coloum will start from 0
        int dp[][] = new int[coins.length+1][amount+1];

        //first row will be populated first because 0 coins cannot be used to form any amount;
        for (int j = 1; j < dp[0].length; j++){
            dp[0][j] = amount+1;
        }

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                //if amount is less than coin value then we cannot use those coins to create less values.
                if (coins[i-1] > dp[i][j]){
                    //copy the value from above row because above coins have already calculated denominations
                    //for that amount
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    //else check minimum denominations from above and check if we include that particular coin
                    //then what was the value calculated in the past with that remainder value.
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        int res = dp[dp.length-1][dp[0].length-1];
        if (res >= amount+1){
            return -1;
        }
        else{
            return res;
        }
    }
}

/*
Leetcode analysis:
Runtime: 20 ms, faster than 35.23% of Java online submissions for Coin Change.
Memory Usage: 39.4 MB, less than 15.96% of Java online submissions for Coin Change.

 */

//I tried to use single array too using similar logic.

/*
code using single array:
TC: O(nlog(n))
SC: O(n)

public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 0; i<= amount;i++){
            for (int j = 0; j< coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],1 + dp[i-coins[j]]);
                }
                else{
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
 */