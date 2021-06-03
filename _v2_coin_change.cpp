// Time Complexity : O(m*n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this -

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        int i, j;
        int min_val;
        int temp;
        
        int lookup[10001] = {0};
        
        for(i = 1; i <= amount; i++)
        {
            min_val = INT_MAX;
            
            for(j = 0; j < coins.size(); j++)
            {
                if(i - coins[j] < 0 || lookup[i - coins[j]] < 0)
                {
                    continue;
                }
                
                temp = 1 + lookup[i - coins[j]];
                
                if(temp < min_val)
                {
                    min_val = temp;
                }
            }
            
            if(min_val != INT_MAX)
                lookup[i] = min_val;
            else
                lookup[i] = -1;
        }
        
        return lookup[amount];
    }
};