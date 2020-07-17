// Time Complexity : O(T*N), N is number of coins and T is Target Amount
// Space Complexity : O(T*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The possible target values that can happen is from 0 to T amount. We can count the minimum coins
// for any target value before T and using that subproblem I can compute minimum number of coins for T.
// For calculating min number of coins for T, we observe that, it is minimum from the number of coins
// if I don't consider a coin I and the number of coins to find (T-I) amount + 1 coin.

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int len = coins.length;
        if (len == 0) return 0;

        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < memo[0].length; i++) {
            memo[0][i] = Integer.MAX_VALUE - 1;
        }
        /*By default Oth column will have value 0, so no need to initialize*/

        for (int i = 1; i <= memo.length - 1; i++) {
            for (int j = 1; j <= memo[0].length - 1; j++) {
                if (j < coins[i - 1]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    /*Take minimum of the previous element or take current_amount-current coin + 1*/
                    memo[i][j] = Math.min(memo[i - 1][j], 1 + memo[i][j - coins[i - 1]]);
                }
            }
        }

        return memo[len][amount] + 1 == Integer.MAX_VALUE ? -1 : memo[len][amount];
    }


}
