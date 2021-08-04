//Time Complexity : O(n)
//Space Compexity: O(1)
public class Solution {
    public int CoinChange(int[] coins, int amount) {
         if (coins == null || coins.Length == 0){
                return -1;
            }
            return helper(coins, amount, 0,0);
    }
     private int helper(int[] coins, int amount, int index, int minCoins)
        {
            //base
            if (amount == 0)
            {
                return minCoins;
            }
            if (index >= coins.Length || amount < 0)
            {
                return -1;
            }
            //logic
            //don't choose
            int case1 = helper(coins, amount, index + 1, minCoins);
            //choose case
            int case2 = helper(coins, amount - coins[index], index, minCoins + 1);
            if(case1 == -1)
            {
                 return case2;
            }
             if(case2 == -1)
             {
                 return case1;
             }

            return Math.Min(case1, case2);

        }
}