

/* ################################################## Recursive Solution ################################################## */
class Solution {
public:
    int helper(vector<int>& coins, int amount, int idx)
    {
        if (idx >= coins.size() || amount < 0) {
            return INT_MAX - 2;
        }

        if (amount == 0) {
            return 0;
        }


        int min1 = 1 + helper(coins, amount - coins[idx], idx);
        int min2 = helper(coins, amount, idx + 1);

        return min(min1, min2);
    }

    int coinChange(vector<int>& coins, int amount)
    {
        int min = helper(coins, amount, 0);
        if (min == INT_MAX - 2) {
            return -1;
        } 

        return min;
    }
};

/* ################################################## DP Solution ################################################## */



class Solution {
public:
    int coinChange(vector<int>& coins, int amount)
    {
        vector<int> dp(amount + 1);
        
        fill(dp.begin(), dp.end(), INT_MAX - 2);
        dp[0] = 0;
    
        for (int i = 1; i <= coins.size(); i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]]);
            }
        }
        
        if (dp[dp.size() - 1] == INT_MAX - 2) {
            return -1;
        }

        return dp[dp.size() - 1];
    }
};
