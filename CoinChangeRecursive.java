// Time Complexity : O( 2^(T/min(coin array)) ), N is number of coins and T is Target Amount
// Space Complexity : O(T/min(coin array))
// Did this code successfully run on Leetcode : No, reached TLE for large target value
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We observe that one coin can repeat and be used again to sum to target value. Using recursion, for every coin value
// we can either choose that coin or not choose that coin. The reason for not choose a coin is, if choosing the coin leads to
// exceeding the target value. After choosing the coin, we have to find the minimum of 2 choices, minimum of number of coins
// required to reach target T, if I choose coin X or I do not choose coin X. Each time I choose a coin X, I reduce the target T by
// X and repeat until target reaches 0;

public class CoinChangeRecursive {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int len = coins.length;
        if (len == 0) return 0;

        return getCoinChangeRecursive(coins, amount, len - 1, 0);
    }

    private static int getCoinChangeRecursive(int[] coins, int amount, int index, int coinCount) {
        if (index < 0 || amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return coinCount;
        }

        int includeCoin = getCoinChangeRecursive(coins, amount - coins[index], index, coinCount + 1);
        int notIncludeCoin = getCoinChangeRecursive(coins, amount, index - 1, coinCount);

        if (includeCoin == -1) return notIncludeCoin;
        if (notIncludeCoin == -1) return includeCoin;

        return Math.min(includeCoin, notIncludeCoin);
    }

}
