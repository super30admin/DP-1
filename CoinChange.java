// Time Complexity : O(na)
// Space Complexity : O(na)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int dp[][]    = new int[coins.length][amount + 1];

        int ans = getCoins(coins, 0, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public int getCoins(int[] coins, int index, int amount, int dp[][]) {

        if (amount == 0) {
            return 0;
        }
        if(amount < 0 || index == coins.length){
            return Integer.MAX_VALUE;
        }

        if(dp[index][amount] == 0)
        {
            int selected = getCoins(coins, index, amount - coins[index], dp);

            if (selected != Integer.MAX_VALUE){
                selected += 1;
            }
            int notSelected = getCoins(coins, index + 1, amount, dp);
            dp[index][amount] = Math.min(selected, notSelected);
        }
        return dp[index][amount];
   }


    public static void main(String[] args) {
        int [] coins = {1,2,5};
        CoinChange obj = new CoinChange();
        System.out.println(obj.coinChange(coins, 11));
    }

    }
