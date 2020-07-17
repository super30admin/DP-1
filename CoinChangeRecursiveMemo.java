// Time Complexity : Not sure how to come up with time complexity for this approach
// Space Complexity : O(T*N))
// Did this code successfully run on Leetcode : No, didn't successfully run for large values
// Any problem you faced while coding this : Difficult to debug for large values


// Your code here along with comments explaining your approach
// We observe that one coin can repeat and be used again to sum to target value. Using recursion, for every coin value
// we can either choose that coin or not choose that coin. The reason for not choose a coin is, if choosing the coin leads to
// exceeding the target value. After choosing the coin, we have to find the minimum of 2 choices, minimum of number of coins
// required to reach target T, if I choose coin X or I do not choose coin X. Each time I choose a coin X, I reduce the target T by
// X and repeat until target reaches 0;
// We just memoize the repeated value for number of coins from 0 to ith index required to reach Target T in a cell memo[i][T];


public class CoinChangeRecursiveMemo {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int len = coins.length;
        if (len == 0) return 0;

        Integer[][] memo = new Integer[coins.length + 1][amount + 1];
        return getCoinChangeRecursiveMemo(coins.length - 1, coins, amount, 0, memo);
    }

    private static int getCoinChangeRecursiveMemo(int index, int[] coins, int remainingAmount, int cointCount, Integer[][] memo) {
        if (index < 0 || remainingAmount < 0) {
            return Integer.MAX_VALUE - 1;
        }

        if (memo[index][remainingAmount] != null) {
            return memo[index][remainingAmount];
        }

        if (remainingAmount == 0) {
            return cointCount;
        }

        int includeCoin = getCoinChangeRecursiveMemo(index, coins, remainingAmount - coins[index], cointCount + 1, memo);
        int notIncludeCoin = getCoinChangeRecursiveMemo(index - 1, coins, remainingAmount, cointCount, memo);

        memo[index][remainingAmount] = Math.min(includeCoin, notIncludeCoin);
        return memo[index][remainingAmount];
    }

}
