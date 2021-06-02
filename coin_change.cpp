// Time Complexity : Not sure
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : No (Fes Tests Worked; Some got Time limit exceeded)
// Any problem you faced while coding this - Not sure why I am getting time limit exceeded even though I am maintaining a lookup table for values

class Solution {
private:
    int lookup[10001] = {0};
    
public:
    int coins_dp(vector<int>& coins, int n)
    {
        int i;
        int min_val = INT_MAX;
        int temp;

        // Change not possible
        if(n < 0)
        {
            return -1;
        }
        
        // Base condition
        if(n == 0)
        {
            return 0;
        }
        
        int num;
        
        // Iterate for each coin type
        for(i = 0; i < coins.size(); i++)
        {
            if(n-coins[i] < 0)
            {
                continue;
            }

            // Value present in lookup
            if(lookup[n-coins[i]] > 0)
            {
                temp = lookup[n-coins[i]];
            }
            //Value not present in lookup
            else
            {
                temp = coins_dp(coins, n - coins[i]);
            }

            //Find Minimum Coins Option            
            if(temp != -1)
            {    
                min_val = min(min_val, temp);  
            }             
        }
        
        if(min_val != -1 && min_val != INT_MAX)
            num = 1 + min_val;
        else
            num = -1;
        
        lookup[n] = num;
        return num;
    }
    
    
    int coinChange(vector<int>& coins, int amount) {
        
        return coins_dp(coins, amount);
        
    }
};