
class Solution {
    public int coinChange(int[] coins, int amount) {

        // null

        if (coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        // fill dummy row

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // fill dummy column

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 99999;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // if denom is less than the amount, we only have case 0

                if (coins[i - 1] > j) {

                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }

            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];

        if (result > amount)
            return -1;
        return result;
    }

}

// //recursive
// //time: O(m+n) where m for choosing until the end and n for not choosing at
// the last step

// class Solution {
// public int coinChange(int[] coins, int amount) {

// //null
// if(coins == null || coins.length == 0) return 0;

// return helper(coins,amount,0,0);

// }

// private int helper(int[] coins,int amount,int index,int minCoins){

// //base
// if(amount ==0) return minCoins;
// if(amount < 0 || index == coins.length) return -1;

// //logic for choosing

// int case1 = helper(coins,amount-coins[index],index,minCoins+1);

// // logic for not choosing

// int case2 = helper(coins,amount,index+1,minCoins);

// if(case1 == -1) return case2;
// if(case2 == -1) return case1;

// return Math.min(case1,case2);
// }

// }