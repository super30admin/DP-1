// Approach: top down dynamic programming with memoization
// Time Complexity : O(n*a) where n is the num of denominations and a is the amount
// Space Complexity: O(n*a) in worst case, n*a space for Dp array and call stack a/max denomination
public class Solution {
    int[,] dp;
    int[] coins;
    public int CoinChange(int[] coins, int amount) {
        this.coins = coins;
        dp = new int[coins.Length, amount+1];
        
        int ans = rMinimum(0,amount);
        
        return  ans == Int32.MaxValue ? -1 : ans;
    }
    
    /*
        rMinimum returns the minimum number of coins required to make "amount" with coins from index i to n-1 in coins
    */
    public int rMinimum(int coinIndex, int amount){
        //base condition
        if(amount==0){
            return 0;
        }
        
        if(amount<0 || coinIndex >= coins.Length){
            return Int32.MaxValue;
        }

        //if not calculated
        if(dp[coinIndex, amount] == 0){
            
            //select
            int select = rMinimum(coinIndex, amount-coins[coinIndex]);
            select = select==Int32.MaxValue ? select : select+1;
            
            //not select
            int notselect = rMinimum(coinIndex + 1, amount);
            
            dp[coinIndex, amount] = Math.Min(select, notselect);
        }

        return dp[coinIndex, amount];
    }
}