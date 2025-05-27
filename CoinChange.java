
//Steps
// 1. Use bottom-up DP where coinsDP[i] stores the minimum coins to make amount i.
// 2. For each amount i from 1 to amount, try every coin that can contribute.
// 3. If using a coin is valid, update coinsDP[i] with the minimum of current or 1 + coinsDP[i - coin].
// Ravi
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        int[] coinsDP = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            coinsDP[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin <= i && coinsDP[i - coin] != Integer.MAX_VALUE) {
                    coinsDP[i] = Math.min(coinsDP[i], 1 + coinsDP[i - coin]);
                }
            }
        }

        return coinsDP[amount] == Integer.MAX_VALUE ? -1 : coinsDP[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + result); // Output: 3 (5+5+1)
    }
}
