public class CoinChangeTester {
    public static void main(String[] args) {
        CoinChange obj = new CoinChange();

        int[] coins = { 1,2,5 };

        int amount =11;

        System.out.println(obj.coinChange(coins, amount));
    }
}
