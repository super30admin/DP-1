//I was not quite able to get to the solution , my approach was to determine the coins required by any particular coin value to reach closest to amount
//and the remainder is what we need to form and check with other coins. But could not quite code it out.
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        
        int[] dp = new int[coins.length];
        return dynamic(coins,amount,dp);
        
        
    }
    public int dynamic(int[] coins,int amount, int[] dp)
    {
        int coins_num=0,rem=0;
        for(int i=0;i<coins.length;i++)
        {
            coins_num=amount/coins[i];
            if(coins_num<1){
                return 0;
            }
            rem=amount%coins[i];
            if(rem==0)
                dp[i]=coins_num;
            else 
                dp[i]=coins_num+dynamic(coins,rem,dp);
            
           
            
        }
        return dp[coins.length-1];
        
    }
}