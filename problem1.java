//Brute Force No Memoization

// Height of the tree: (Amount/Minimum Denomination)
// Time Complexity :  O(2^height)
// Space Complexity :  O(height)
// Did this code successfully run on Leetcode :  No
// Any problem you faced while coding this :  No

class BruteForce {

    private int findSolution(int[] coins,int amount,int index){

        if(amount==0){
            return 0;
        }
        if(amount<0 || index==coins.length){
            return Integer.MAX_VALUE;
        }
        
        int nChosen= findSolution(coins,amount,index+1);

        int chosen= findSolution(coins,amount-coins[index],index);
        
        if(chosen!=Integer.MAX_VALUE){
            chosen++;
        }
        
        return Math.min(chosen,nChosen);
    }
    
    public int coinChange(int[] coins, int amount) {
        
        int ans= findSolution(coins,amount,0);

        if(ans==Integer.MAX_VALUE){
            return -1;
        }

        return ans;
    }
}


// With Memoization using 2d array

// Time Complexity :  No.of coins * Amount
// Space Complexity :  No.of coins * Amount
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :  No

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



//Bottom Up Approach- Tabulation
// TC SC O(No.of coins * Amount)

class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int n= coins.length+1;
        int a=amount+1;
        int[][] dp= new int[n][a];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<a; j++){
                //fill the first column with '0'
                if(j==0){
                    dp[i][j]=0;
                }
                //fill first row with infinity
                else if(i==0){
                    dp[i][j]=Integer.MAX_VALUE;
                }
                //for all the other elements
                else{
                    //when the amount is feasible with the current denomination check for both current and previous denomination
                    if(j-coins[i-1]>=0 && dp[i][j-coins[i-1]]!=Integer.MAX_VALUE){
                        dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                    }
                    //if not feasible we will not check for current denomination instead direclty move to the previous denomination
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        //if feasible return otherwise return -1
        return dp[coins.length][amount]==Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }
}



// To Do
// Bottom Up Approach- Tabulation
// TC O(No.of coins * Amount)
// SC O(Amount)