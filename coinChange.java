class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp=new int[coins.length+1][amount+1];
        // System.out.println("amount = "+ amount);
        for(int row=0;row<coins.length+1;row++){
            for(int col=0;col<amount+1;col++){
                // System.out.println("row = "+row);
                // System.out.println("col = "+col);
                if(row==0){
                    if(col==0){
                        dp[row][col]=0;
                    }else{
                        dp[row][col]=amount+1;
                    }
                    // System.out.println("inside 15"+dp[row][col]);
                }else if(col<coins[row-1]){
                    dp[row][col]=dp[row-1][col];
                    // System.out.println("inside 18"+dp[row][col]);
                }
                else{
                    dp[row][col]=Math.min(1+dp[row][col-coins[row-1]],dp[row-1][col]);
                    // System.out.println("inside 23");
                    // System.out.println("23 value = " + dp[row][col]);
                }
            }
        }
        if(dp[coins.length][amount]>amount){
            return -1;
        }
        return dp[coins.length][amount];
    }
}