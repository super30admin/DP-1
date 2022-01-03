//TC: O(m+n)
//SC: O(m*n)
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount+1];
        dp[0][0] = 0;
        for(int j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1; //to store the value infinity or any value greater than amount
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j]; //carry forward the
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }
        }
        int result = dp[dp.length-1][dp[0].length-1];
        if(result > amount) { // when result will be infinity or amount+1 as mentioned in the line 6;
            return -1;
        }
        return result;
    }
}


//table of dp
//  0 1 2 3 4 5 6 7 8 9 10 11
//0 0 i i i i i i i i i i i
//1 0 1 2 3 4 5 6 7 8 9 10 11
//2 0 1 1 2 2 3 3 4 4 5 5 6
//5 0 1 1 2 2 1 2 2 3 3 2 3

//row = coins, columns = amount, i = infinity or amount + 1