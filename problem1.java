//TC=(n^2)

class Solution {
    
    private int [][]dp;  // we are creating a 2D array storage to memorize our solutions and recall them whenever needed
    
    int coinChange(int[] coins, int index, int amount){
        
        if(amount==0){
            return 0;
        }
        if(amount<0 || index==coins.length){   //if we are done with all of coins or combination couldn't be made then we will return a max value(very large value). This amount<0 will happen after choosing a coin.
            return Integer.MAX_VALUE;
        }
            
            if(dp[index][amount]>0){  // this has already been solved so access it from storage
                return dp[index][amount];
            }
            //If encountering for the first time we will proceed
        
            //we are creating a recursive function
        
            // if we don't choose a coin
            int notchoose= coinChange(coins, index+1, amount); // amount remains same as we are skipping a coin
        
            // if we choose a coin
            int choose= coinChange(coins, index, amount-coins[index]); // amount decreases by the value of coin which we choose and we can choose this coin again. We are not adding 1 in this step because if coinchange is MAX_VALue then it will overflow. So we will check the condition in the next step and add 1.
        
            if(choose!=Integer.MAX_VALUE){
                choose+=1; // Everytime we choose a coin, 1 gets added to number of coins and not denomination.
            }
            dp[index][amount]= Math.min(choose, notchoose);
         return dp[index][amount];
    }
    
    public int coinChange(int[] coins, int amount) {
        
        dp= new int [coins.length][amount+1];// we are storing every result correspoonding to index value and amount at its particular position
        
        int ans=coinChange(coins, 0, amount);
        
        if(ans==Integer.MAX_VALUE){    // if amount<0 we will return -1
            return -1;
        }
        
        return ans;
    }
    
}


