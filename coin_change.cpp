//time complexity is O(n*a) where n is no of denominations, a is amount
//space complexity is O(a) a is amount for dp[] array which consists of indices 0 to a

//approach: iterating over 0 to amount and iterating over coins to find min no of coins needed 

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, INT_MAX); //size is amount +1 and all are innitialized to max number 
        //this array consists of min no of coins needed to the amount
        dp[0] = 0;//basecase 0 coins needed for amount 0
        for(int i=0; i <= amount; i++){
            for(int coin : coins){
                if(i-coin >=0 && dp[i-coin] != INT_MAX){
                    dp[i] = min(dp[i], dp[i-coin] + 1); 
                }
            }
        }
        if(dp[amount] == INT_MAX){
            return -1;
        }
        else{
            return dp[amount];
        }
    }
};
