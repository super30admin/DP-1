// Time Complexity :Exponential
// Space Complexity : O(n). In the worst case the maximum depth of recursion is n. 
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
/*
 * We want to minimize and thus we tried greedy. We then do exahuastive search(recurssion) using DO NOT CHOOSE CHOOSE method.
 * Choose: means we used the coin, amount gets updated and index remains the same (Infinite supply)
 * Not choose: amount and coinUsed will be the same and increment the index.
 * Base case: If index is equal to length or we get negative amount. If amount is 0 we return coinsUsed.
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length < 1) {
            return -1;
        }
        return recurse(coins, 0, amount, 0);
    }
    
    private int recurse(int[] coins, int index, int amount, int coinsUsed) {
        //Base case
        if(index == coins.length || amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return coinsUsed;
        }
        //Logic: Do not choose choose method
        int pick = recurse(coins, index, amount - coins[index], coinsUsed + 1);
        int notPick = recurse(coins, index + 1, amount, coinsUsed);
        if(pick == -1) {
            return notPick;
        } else if(notPick == -1){
            return pick;
        }
        return Math.min(pick, notPick);
    }
}

// Time Complexity : O(n*m); n = coins.length, m = amount;
// Space Complexity : O(n*m); n = coins.length, m = amount;
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
/*
 * DP where we consider dimension = length of the deciding factor. (amount is -ve, index == length). We creat dp[][] with coins + 1 = row and amount + 1 = coloumn
 * Fill 1st ROW with amount + 1, not max value to avoid integer overflow. Fill dp matrix: if j < amount (As we added extra row we will get amount at 1 lesser index in array)
 * We copy from previous row,  else min between previous row(0 notpick case) or 1(pick case) which is in same row 
 * but coloumn - amount + 1.
 */
class CoinChangeDp {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length < 1) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 1; i < amount + 1; i++) {
            dp[0][i] = amount + 1;
        }
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1; j < amount + 1; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}
