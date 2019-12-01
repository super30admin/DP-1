class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {


        sort(coins.begin(), coins.end());
        int max_amount = amount + 1;
        vector<int> dp(amount + 1, max_amount);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (coins[j] <= i) {
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1);  //amount - current money taken
                }else {
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

};

//Time complexity: O(n * amount)
//Space Complexity: O(n * amount)
