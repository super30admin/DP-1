// Recursive Approach
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0){
            return 0;
        }
        return helper(coins, amount, 0, 0);
    }
    public int helper(int[] coins, int amount,int currCoins, int index){
        //base
        if(amount == 0){
            return currCoins;
        }
        if(amount < 0 || index == coins.length){
            return -1;
        }
        //logic
        //not choose (zero case)
        int case1 = helper(coins, amount, currCoins, index+1);
        //choose (one case)
        int case2 = helper(coins, amount - coins[index], currCoins + 1, index);
        if(case1==-1){
            return case2;
        }
        if(case2==-1){
            return case1;
        }
        return Math.min(case1, case2);
    }
}

//DP solution


// m -> coins.length, n -> amount
// Time Complexity : O(m * n)
// Space Complexity : O(m * n)

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = amount + 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1] > amount){
            return -1;
        }
        return dp[dp.length - 1][dp[0].length-1];
    }
}

