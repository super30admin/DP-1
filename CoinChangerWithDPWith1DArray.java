// Time Complexity : O(m*n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes

public class CoinChangerWithDPWith1DArray {

    public static int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[] dpArr = new int[n+1];

        for(int j=1; j<=n; j++)
        {
            dpArr[j] = amount+1;
        }

        for(int i=1; i<= m; i++)
        {
            for(int j =1; j<=n; j++) {
                if(j >= coins[i-1])
                {
                    dpArr[j] = Math.min(dpArr[j], (dpArr[j - coins[i-1]] + 1));
                }
            }
        }
        if(dpArr[n] > amount)
            return -1;
        else
            return dpArr[n];
    }

    public static void main(String args[]) {
        int coins[] = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins , amount));
    }
}