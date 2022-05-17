    //Dynammic Programming (Bottom Up Approach)
    //Time Complexity is O(n*m), n->coins.length, m->amount;
    //Space Complexity is O(n*m), n->coins.length, m->amount;
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Noclass Solution {
    
    public int coinChange(int[] coins, int amount) {
        //Since more than 1 deciding factors (remaining amount and which coins to use, create 2D array)
        //coins.length+1 -> since creating a dunny row for 0 denomination
        //amoint+1 -> since the remaing sum amount are from 0 to amount(i.e 1 + amount)
        int[][] dp = new int[coins.length+1][amount+1];
        for(int j=1; j<dp[0].length; j++){
            //Assign it max possible value;
            dp[0][j]=100000;
        }
        //Since first column is automatically initialized with '0' and first row is initialized with the max value from above
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j<coins[i-1]){
                    dp[i][j]=dp[i-1][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j], dp[i][j-coins[i-1]]+1);
                }
            }   
        }
        if(dp[coins.length][amount]>=100000) return -1;
        else return dp[coins.length][amount];
    }
}
