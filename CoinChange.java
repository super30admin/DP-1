/**
 * Exponential Time Complexity 2 power (n + m) where n is coins and m is amount.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, 0);
    }

    int helper(int[] coins, int amount, int index) {
        // base case
        if (amount < 0 || coins.length == index) return Integer.MAX_VALUE - 10;
        if (amount == 0) return 0;

        // not choose
        int notChoose = helper(coins, amount, index + 1);

        // choose
        int choose = 1 + helper(coins, amount - coins[index], index);

        return Math.min(choose, notChoose);
    }

    public static void main(String[] args) {
        int i = new CoinChange().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}
