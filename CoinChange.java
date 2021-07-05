import java.util.*;
class CoinChange {
    public int CoinChange(int[] coins, int amount) {
        int max = amount + 1;
        int [] dp = new int[max];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i)
                    dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args){
        CoinChange c = new CoinChange();
        int [] coins = {1,2,5};
        int amount = 16;
        System.out.println(c.CoinChange(coins,amount));
    }
}