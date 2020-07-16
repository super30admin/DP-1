// Time Complexity : O(k.n) where k is the target amount
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Two loops: outer through all numbers till amount and inner through all denominations
// 2. DP: Maintain cache array with initial value as INT_MAX
// 3. Recurrence relation: cache[amt] = min(cache[amt], cache[amt-coin]+1);


class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> cache(amount+1,INT_MAX);
        cache[0]=0;
        for(int amt=1;amt<=amount;amt++){
            for(auto coin: coins){
                if(amt>=coin && cache[amt-coin]!=INT_MAX)
                    cache[amt] = min(cache[amt], cache[amt-coin]+1);
            }
        }
        if(cache.back() == INT_MAX) return -1;
        else return cache.back();
    }
};