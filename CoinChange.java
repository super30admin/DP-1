// Time Complexity : O(m*n), where m is the length of the coins array and n will be amount
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No major issues

// Your code here along with comments explaining your approach:
// - We use Dynamic Programming with 1D array to compute the minimum coins required to make up the amount
// - First we fill the dp 1D array with infinite values for zero coins for all the amounts because we cant compute or sum up to the amount with 0 coins
// - then for every coin we iterate with all the amounts possible within the amount we get the min coins to make up to the amount
// - we take the min value between the not picking the particular coin i.e we take previous step value and compare it with remaining amount after picking that coin + 1
// - So we have the final dp array for the amount with min value which is min coins required to compute the target amount

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;

        int[] dp = new int[n+1];
        dp[0] = 0;
        // fill the dp array with max value for amount 0
        for(int j=1;j<=n;j++){
            dp[j] = 999999;
        }
        //start from 1st index which is the first coin
        for(int i=1;i<=m;i++){
            for(int j=0;j<=n;j++){
                //if amount is less than the coin value, then just the previous value
                if(j < coins[i-1]){
                    dp[j] = dp[j];
                }
                else{
                    //take the minimum of the previous coin path and the value of amount path after subtracting the picked coin from the current amount
                    dp[j] = Math.min(dp[j],1+dp[j - coins[i-1]]);
                }
            }
        }
        //if the last dp array value is still the max value, then we didn't find any coins to make up to the target amount, so return -1
        if(dp[n] == 999999){
            return -1;
        }
        //return the last dp array value which has the min count of coins to make up the target amount
        return dp[n];
    }
    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        int result = obj.coinChange(coins,amount);
        System.out.println("fewest number of coins that you need to make up the amount: " + result); // Output: 3

        int[] coins1 = {2};
        int amount1 = 3;
        int result1 = obj.coinChange(coins1,amount1);
        System.out.println("fewest number of coins that you need to make up the amount: " + result1); // Output: -1

        int[] coins2 = {1};
        int amount2 = 0;
        int result2 = obj.coinChange(coins2,amount2);
        System.out.println("fewest number of coins that you need to make up the amount: " + result2); // Output: 0
    }
}
