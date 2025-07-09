// Time Complexity : O(n*amount) since for each coin we iterate through the amount
// Space Complexity : O(n*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We solve this using Dynamic Programming.
// I used a 2D dynamic programming (dp) table where rows are coins and columns are amounts from 0 to target.
// First, I filled the first row with a big number (amount + 1) since we can't make any amount without coins.
// Then for each coin and amount, I checked if I can pick the coin or skip it and stored the minimum coins needed.
// In the end, if the value is still greater than amount, it means it's not possible to make that amount.



public class coinChange {
    public int solve(int[] coins, int amount){
        if(coins==null || coins.length==0){
            return -1;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        for(int j = 1; j <=amount; j++){
            dp[0][j] = amount+1; 
        }
        for(int i=1; i<=coins.length;i++){
            for(int j=0; j<=amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                    }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i - 1]]);
                    }
            }
        }

        if(dp[coins.length][amount]>amount){
            return -1;
        }
        return dp[coins.length][amount];


    }
    public static void main(String[]args){
        coinChange ob = new coinChange();
        int[] coins1 = new int[] {1,2,5};
        int[] coins2 = new int[] {2};
        int[] coins3 = new int[] {1};
        System.out.println("Output is: "+ob.solve(coins1, 11));
        System.out.println("Output is: "+ob.solve(coins2, 3));
        System.out.println("Output is: "+ob.solve(coins3, 0));




    }
    
}
