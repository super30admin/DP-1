/**
 * Coins
 */
public class Coins {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return 0;
        else
            return minCoins(coins, 0, amount, 0);
    }

    public int minCoins(int[] coins, int index, int amount, int coinsUsed) {

        if (amount == 0)
            return coinsUsed;
        if (amount < 0 || index == coins.length)
            return -1;

        int case1 = minCoins(coins, index + 1, amount, coinsUsed);
        int case2 = minCoins(coins, index, amount - coins[index], coinsUsed + 1);

        if (case1 < 0)
            return case2;
        if (case1 < 0)
            return case1;

        return Math.min(case1, case2);

    }

    public static void main(String[] args) {
        Coins cr = new Coins();
        // int[] nums = { 1, 2, 5 };
        // int[] nums = { 2 };
        int[] nums = { 1, 2, 5 };
        System.out.println(cr.coinChange(nums, 11));
    }
}