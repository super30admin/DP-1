class Solution {
//Brute force approach (Exhaustive approach)
// Time Complexity : Exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

    public int coinChange(int[] coins, int amount) {

       //make a recursive call to function 
        return calculateCoins(coins, amount, 0,0);
    }
    
    private int calculateCoins(int[] arr, int amount, int index, int coinsUsed){
        //base case is if the amount is less than 0 or the length of array is equal to index 
        if(index==arr.length || amount<0){
            return -1;
        }

        //if amnt sums to 0 means we have found the ans
        if(amount==0){
            return coinsUsed;
        }
        //case 0 ,do not choose the coin, so the index becomes next index 
        int case0= calculateCoins(arr, amount, index+1, coinsUsed);
        
        //case1, choose the coin so the amount - current coin
        
        int case1= calculateCoins(arr, amount-arr[index] , index, coinsUsed+1);
        
        //if the case 1 returns -1, return ans from case 1, 
        //because if we compare -1 and other -1 will be minimum
        if(case0==-1){
            return case1;
        }
        
        if(case1==-1){
            return case0;
        }
        
        return Math.min(case0,case1);
    }

//Optimized Implementation
// Time Complexity : O(m*n) n- No of coins (len of array), m- amount 
// Space Complexity :O(m*n) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


    public int coinChangePart2(int[] coins, int amount) {
        if(coins==null || coins.length==0) return -1;
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        //fill the first row with infinity
        for(int i=1;i< amount+1;i++){
            dp[0][i] = amount+1;
        }
        
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                //for the amount less than current amount the and can be calculated from previous row
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                //take min of case 0 and case 1
                else{
                    dp[i][j]= Math.min(dp[i-1][j] , dp[i][j-coins[i-1]]+1);    
                }
                
            }
        }
        
        //the base case when amount exceeds given amt
        if(dp[n][amount] == amount+1){
            return -1;
        }
        //else the last element is the ans
        return dp[n][amount];
    }
    
}