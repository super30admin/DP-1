import java.util.Arrays;

public class CoinChange {

// Time Complexity : O(n * m)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount < 0) return -1;

            //creating dp array of amount + 1 since starting at 0
            int[] dp_arr = new int[amount + 1];

            //Fill array with invalid value and set dp_arr[0] to valid value of 0 since 0 coins needed to make 0 change
            Arrays.fill(dp_arr, amount + 1);
            dp_arr[0] = 0;

            //Compute and store min number of coins required in the dp_arr
            for (int i = 0; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp_arr[i] = Math.min(dp_arr[i], 1 + dp_arr[i - coins[j]]);
                    }
                }
            }
            //Return dp_arr[amount] if element wasn't changed else return -1
            return dp_arr[amount] > amount ? -1 : dp_arr[amount];
        }
    }
}
