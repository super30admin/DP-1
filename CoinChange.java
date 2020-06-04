class Solution {
    // Time Complexity : O(No. of coins * Amount)
// Space Complexity :  O(No. of coins * Amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    
    
    public int coinChange(int[] coins, int amount) {
       if(coins == null || coins.length == 0) return 0;
       int[][] dp = new int[(coins.length) + 1][amount + 1];
        //base case, we will have 0 coins, so that we add further 1 as we include a coin.
       for(int i=0;i<dp.length;i++){
           dp[i][0] = 0; 
       }
        //to have the global minima, we are taking initial values as max integer.
       for(int i =0;i<dp[0].length;i++){
           dp[0][i] = 9999;
       }
       for(int i =1; i<dp.length; i++){
           for(int j = 1; j<dp[0].length;j++){
               //if coin value exceeds the amount remaining, take the value formed without using this coin, i.e; row above
               if(j<coins[i-1]){
                   dp[i][j] = dp[i-1][j];                   
               }
               //if the coin value doesn't exceed the amount remaining, take the min ( coins without this coin , add 1 to                  //the num of coins we already have with this coin(by backtracking exactly the coin value times))
               else{
                   dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
               }
           }
       }
        //last row last column will always contain the min coins.
        int result = dp[dp.length-1][dp[0].length-1];
        //if target amount is not reached with any combination of coins, return -1
        if(result >= 9999){
            return -1;
        }
        return result;
    }
}




class Solution {
     // Time Complexity :
// Space Complexity :  
// Did this code successfully run on Leetcode : Timelimit exceeding
// Any problem you faced while coding this : 

    
    
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        //helper function which recursively works so that all possible combinations are taken to calc min number of coins.
        return minCoins(coins, amount, 0, 0);
    }
    
    //we definitely need coins array and amount for function
    //additinally
    //index -- to track the coins array index
    //min -- to track the min number of coins at given point.
    private int minCoins(int[] coins, int amount, int index, int min){
        
        //BASE CASE
        
        //if amunt becomes 0, it means we are able to get the target amount with the coins we have, so return the min num of         //coins till that point.
        if(amount == 0) return min; 
        //using the main logic line 26,28 and assinging the return value as -1
        if(amount<0 || index == coins.length) return -1;
        
        //MAIN LOGIC
        
        //not taking the current index element
        //so amount would not change, min coins at that point would not change
        //so incrementing index for call, so that next coin may partipicate in it.
        int case1 = minCoins(coins, amount, index+1, min);
        //taking the current index element, 
        //so amount would decrease by that coin value
        //and min coins get increment and index remains same so that call will decide its particaipation.
        int case2 = minCoins(coins, amount-coins[index],index, min+1);
        //case1 is not including the element --- so if it reaches end, index will exceed the coin array size,
        if(case1 == -1) return case2;
        //case2 is including the element -- so it might reach a end where amount nagative
        if(case2 == -1) return case1;
        //if either of the above 2 lines are not happening, take the min number of coins present.
        return Math.min(case1, case2);
        
    }
}