//time - O(mn) - m -> number of coins, n -> amount
//space - O(n) - n -> amount
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        result[0] = 0; //number of coins to  make $0 is 0
        for(int i = 1; i <= amount; i++)
        {
            for(int j = 0; j < coins.length; j++)
            {
                //if the denomination of coin is less than amount pick that coin and amount becomes current amount - coin value
                if(coins[j] <= i)
                {
                    result[i] = Math.min(result[i], 1 + result[i - coins[j]]);
                }
            }
        }
        return result[amount] > amount ? -1 : result[amount];
    }
}
