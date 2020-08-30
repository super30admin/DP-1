public class CoinChangeRecursive {
    public int coinChangeRec(int idx, int[] coins, int amount) {
        if(amount == 0) return 1;

        if(amount < 0) return 0;

        return coinChangeRec(idx + 1, coins, amount - coins[idx]) + coinChangeRec(idx, coins, amount - 1);

    }

    public int coinChange(int[] coins, int amount) {
        return coinChangeRec(0, coins, amount);
    }

    public static void main(String args[]) {
        CoinChange ch = new CoinChange();

        int[] coins = { 2, 3, 5 };
        int amount = 7;
        System.out.println("Minimum no of coins needed = " + ch.coinChange(coins, amount));
    }
}