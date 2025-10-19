import java.util.Arrays;

/**
 * Memoization
 */
public class CoinChange1 {

    private int[][] memo;


    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(coins, amount, 0);
    }

    int helper(int[] coins, int amount, int index) {
        // base case
        if (amount < 0 || coins.length == index) return Integer.MAX_VALUE - 10; // invalid path
        if (amount == 0) return 0; // valid path

        if (memo[index][amount] != -1) return memo[index][amount];

        // not choose
        int notChoose = helper(coins, amount, index + 1);

        // choose
        int choose = 1 + helper(coins, amount - coins[index], index);
        int result = Math.min(choose, notChoose);
        memo[index][amount] = result;
        return result;
    }

    public static void main(String[] args) {
        int i = new CoinChange1().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}
