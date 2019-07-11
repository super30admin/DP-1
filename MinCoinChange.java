// Time Complexity : O(n*m) n is size of coin array and m is amount
// Space Complexity : O(n*m) n*m storage
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach


class MinCoinChange {
    
    public int coinChange(int[] coins, int amount) {
       
        int[][] dp = new int[coins.length+1][amount+1];

        //init 0 in first column
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }

        //init max to 1st row
        for(int j=1;j<dp[0].length;j++){
            dp[0][j] = 9999;
        }

        //dp table
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                
                //copy from top
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }

        int result = dp[coins.length][amount];
        if(result >= 9999){
            return -1;
        }

        return result;


    }
    public static void main(String[] args){
        System.out.println("MinCoinChange");

        int[] coins = {1,5,6,9};
        int amount = 11;

        MinCoinChange obj = new MinCoinChange();
        System.out.println(obj.coinChange(coins, amount));

    }
}