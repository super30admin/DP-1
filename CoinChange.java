// Time Complexity :O(n*m) n refers to the number of coin denominations, m refers to the amount value
// Space Complexity :O(n*m) n refers to the number of coin denominations, m refers to the amount value
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No





class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] da = new int[coins.length+1][amount+1];
        
        for(int i=0; i<=coins.length; i++)  //Stores 0 in every ith index as no coin is required to sum it up to 0
            da[i][0]=0;
        for(int j=0; j<=amount; j++) //Stores Max_Value in every jth index as 0 denomination requires infinte coins to sum it up to any positive number
            da[0][j] = 99999;
        
        for(int i=1; i<=coins.length; i++)
        {
            for(int j=1; j<=amount; j++)
            {
                if(coins[i-1]>j) //Checking if the coin is greater than the amount
                    da[i][j]=da[i-1][j]; //Takes the value of the previous denomination
                else
                    da[i][j]=Math.min(1+da[i][j-coins[i-1]], da[i-1][j]); //The current coin is 1 and the number of coins required to make the remaining amount
            }
        }
        return da[coins.length][amount]>=99999? -1:da[coins.length][amount]; //Returns the number of coins 
    }
}