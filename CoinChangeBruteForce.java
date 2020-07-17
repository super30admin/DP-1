// Time Complexity : O(N^N), N being number of coins. This recursive approach would result in duplicate paths which are unnecessary.
// Space Complexity : O(T/ min(coin array)), at any point of time, the maximum values in the stack would be Target/ minimum coin value
// Did this code successfully run on Leetcode : No, reached TLE. Will submit the updated code after the class.
// Updated code is in other files.


// Any problem you faced while coding this : Could come up with recursive approach but not the one with dp.
// Your code here along with comments explaining your approach
// I will need to find all combinations of coins that totals to "amount". After find one combination I
// can count the coins, if the count is minimum that any other combinations of coins, that is the answer.
// I can incrementing the count if it is valid amount, i.e subtracting the coin from  amount is not less than zero.
// If the amount reaches zero, that means we have found one valid combination of coins.
// If the amount goes below zero, we know that it is invalid combination of coins and these coins will not sum up to amount.
// Then I skip that combination and continue to next combination.

public class CoinChangeBruteForce {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int len = coins.length;
        if (len == 0) return 0;

        return getCoinChangeBruteForce(coins, amount);
    }

    private static int getCoinChangeBruteForce(int[] coins, int amount) {
        int[] result = new int[1];
        int[] coinCount = new int[1];
        result[0] = Integer.MAX_VALUE;
        getCoinChange(coins, coinCount, 0, amount, result);

        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }

    public static void getCoinChange(int[] coins, int[] coinCount, int index, int amount, int[] result) {
        if (coins.length == index) return;

        if (amount == 0) {
            result[0] = Math.min(result[0], coinCount[0]);
            return;
        }

        for (int i = index; i < coins.length; i++) {
            if (amount - coins[i] < 0)
                continue;

            coinCount[0] += 1;
            getCoinChange(coins, coinCount, i, amount - coins[i], result);
            coinCount[0] -= 1;
        }

    }
}
