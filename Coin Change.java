class Solution {
    int numCoins = 0;
    
	//Time complexity: O(Amount given * types of coins)
    public int coinChange(int[] coins, int amount) {
       
        int[] memo = new int[amount];
       // Arrays.sort(coins);
        
        return helper(coins, amount, memo);
        //return numCoins;
        
    }
    
    public int helper( int[] coins, int amountSoFar, int[] memo){
        
           if( amountSoFar < 0){
               return -1;
           }

           if(amountSoFar == 0){
               return 0;
           }

           if(memo[amountSoFar - 1] != 0){
               return memo[amountSoFar - 1];
           }
            int min_coins = Integer.MAX_VALUE;
           for(int i =0; i < coins.length; i++){

               
               
                  int res = helper(coins, amountSoFar - coins[i], memo) ;
                  if(res >= 0 && res < min_coins){
                      min_coins = res;
                  
               }


           }
           if(min_coins == Integer.MAX_VALUE){
               memo[amountSoFar - 1] = -1;
           }
            else{
                memo[amountSoFar - 1] = min_coins + 1;
            }
           
           return memo[amountSoFar - 1];
            
        
    }
}