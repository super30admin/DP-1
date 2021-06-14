//Time Complexity=O(S∗n). where S is the amount, n is denomination count. 
//Space Complexity=O(n)


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<unsigned int> dp(amount +1 , INT_MAX);
        dp[0] = 0;
        for(int i = 1 ; i<= amount ; i++)
        {
            for(int x =0 ; x < coins.size() ; x++)
            {
                if( i - coins[x] >= 0 )
                {
                    dp[i] = min(dp[i] , dp[i- coins[x]] +1) ;
                }
                else
                {
                    continue;
                }
            }
        }
        if(dp[amount] != INT_MAX )
        {
            return dp[amount];
        }
        else{
            return -1;
        }
    }
};