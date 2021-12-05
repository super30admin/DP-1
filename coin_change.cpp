//Time complexity : O (coins.length * amount)
//Space complexity : O (coins.length * amount)
//Leetcode : Yes

//Approach:
//          1. Commented is Exhaustive Approach :
                                        // We check for all the possible combinations that make up the value and
                                        // return the one with minimum number of coins required
            // 2. Dynamic Programming : 
            //                             We keep track of all the previous combinations and pick the minimum one that gives us
            //                             minimum number of coins required.

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        if(coins.empty())
            return -1;
        
        //Initialize new 2d array
        vector<vector<int>> dp(coins.size() + 1, vector<int>(amount + 1, 0));
        int infinity = amount + 1;
        dp[0][0] = 0;

        //Set 0th row to infinity
        for(int i = 1 ; i < amount + 1 ; i++)
        {
            dp[0][i] = infinity;
        }
        
        //Apply the approach
        for(int i = 1; i < coins.size() + 1; i++)
        {
            for(int j = 0;j < amount + 1; j++)
            {
                if(j < coins[i - 1])
                {
                    //Amount is lesser it means that current coin needs to be dropped as it is always going to exceed the amount
                    dp[i][j] = dp[i - 1][j];
                }
                else
                {
                    //Find the minimum number of coins with this coin or without this coin
                    dp[i][j] = min(dp[i - 1][j], (dp[i][j - coins[i - 1]] + 1));
                }
            }
        }
        
        if(dp[coins.size()][amount] == infinity)
        {
            return -1;
        }
        
        return dp[coins.size()][amount];
    }
    
//     int recurse(vector<int>& coins, int index, int numberOfCoinsUsed, int amount)
//     {
//         //Base Logic for returning
//         if(amount == 0)
//         {
//             return numberOfCoinsUsed;
//         }
        
//         else if(amount < 0 || index == coins.size())
//         {
//             return -1;
//         }
//         //Dont choose the coin
//         int case0 = recurse(coins, index + 1, numberOfCoinsUsed, amount);
//         //Choose the coin
//         int case1 = recurse(coins, index, numberOfCoinsUsed + 1, amount - coins[index]);
        
//         if(case0 < 0)
//         {
//             return case1;
//         }
//         if(case1 < 0)
//         {
//             return case0;
//         }
        
//         return min(case0,case1);
//     }
};