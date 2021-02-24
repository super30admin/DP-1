//TC: O(n*m) where n is the amount and m is the number of denominations
//SC: O(n+1) where n is the amount 


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        //solved using a bottom up approach. We try to find the minimum no of coins for each subproblem from 0 to amount. Then we try to find the minimum coins for amount based on the preceding counts. 
        
        //easier to sort the coins in ascending order.
        sort(coins.begin(), coins.end());
            
        //amount+1 elements since we can use number of ways to get to 0 amount (which is 0).
        int dp[amount + 1];
        dp[0] = 0;
        //initialize all to amount + 1 (any value larger than amount)
        for(int i=1; i<amount+1; i++)
            dp[i] = amount + 1;
        
        
        //iterate over each element in dp and fill the value in there. We know dp[0] = 0
        for(int i=1; i<amount+1; i++){
            
            //iterate over each coin denomination and try to find an optimal value from there.
            for(int j=0; j<coins.size(); j++){
                //check if coin considered is smaller than amount. If no, then break
                if(coins[j] <= i){
                    //dp[i] will be minimum of current val, and value in table after considering coin[j]. Since coin[j] is considered, we add 1.
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1);                    
                } else break;
            }
        }
        
        //if the value at amount is still the inital value, return -1, since no coins of any denominations could be used. 
        if(dp[amount] == amount+1)
            return -1;
        else return dp[amount];
        
        
        
        
    }
};