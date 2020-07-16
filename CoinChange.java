// Time Complexity : O(N^N), N being number of coins
// Space Complexity : O(1), only constant value.
// Did this code successfully run on Leetcode : No, reached TLE. Will submit the updated code after the class.
// Any problem you faced while coding this : Could come up with recursive approach but not the one with dp.


// Your code here along with comments explaining your approach
// I will need to find all combinations of coins that totals to "amount". After find one combination I
// can count the coins, if the count is minimum that any other combinations of coins, that is the answer.
// I can incrementing the count if it is valid amount, i.e subtracting the coin from  amount is not less than zero.
// If the amount reaches zero, that means we have found one valid combination of coins.
// If the amount goes below zero, we know that it is invalid combination of coins and these coins will not sum up to amount.
// Then I skip that combination and continue to next combination.

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return 0;

        int[] result = new int[1];
        int[] cointCount = new int[1];
        result[0] = Integer.MAX_VALUE;
        getCoinChange(coins, cointCount, 0, amount, result);

        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }

    public void getCoinChange(int[] coins, int[] cointCount, int index, int amount, int[] result) {
        if (coins.length == index) return;

        if (amount == 0) {
            result[0] = Math.min(result[0], cointCount[0]);
            return;
        }

        for (int i = index; i < coins.length; i++) {
            if (amount - coins[i] < 0)
                continue;

            cointCount[0] += 1;
            getCoinChange(coins, cointCount, i, amount - coins[i], result);
            cointCount[0] -= 1;

        }

    }
}
