//Time complexity - 2^n
//Space complexity -

class Solution {
    public int coinChange(int[] coins, int amount) {
      
     //using recursion method
      //null check
      if(coins.length == 0 || coins == null) {return 0;}
      
       return helper(coins,amount,0,0);
    }
  
     public static int helper (int coins[], int amount, int index, int minCoins) {
       //base case 
       //valid path
       if(amount == 0) {
         return minCoins;
       }
       
       //non valid path
       if(index == coins.length || amount < 0) {
         return -1;
       }
       
       //logic
       //choose a coin
       int case1 = helper(coins,amount-coins[index],index, minCoins+1);
        // dont choose a coin
       int case2 = helper(coins,amount,index+1, minCoins);
       
       // case returns -1
       if(case1 == -1) return case2;
       if(case2 == -1) return case1;
       return Math.min(case1,case2);
     }
}