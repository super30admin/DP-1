#include <iostream>
#include <vector>

using namespace std;

//Time complexity : O(n)
//Space complexity : O(1)
//Leetcode : Yes

//Approach :
//        Keep calculating max robbery for each house by including and excluding the house
class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty())
            return -1;
        
        vector<vector<int>> dp(nums.size(), vector<int>(2 , 0));
        
        int skip = 0;
        int pick = nums[0];
        int tempSkip = 0;
        //Initializing first row with 0 and first element
        dp[0][1] = nums[0];
        
        for(int i = 1 ; i < nums.size(); i++)
        {
            //Skipping the current element
            //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
            tempSkip = skip;
            skip = max(skip, pick);
            
            //Selecting the element
            //Means we need to pick the value that we get by skipping the last element
            //dp[i][1] = dp[i - 1][0] + nums[i];
            pick = tempSkip + nums[i];
        }
        
        //return max(dp[nums.size() - 1][0], dp[nums.size() - 1][1]);
        return max(skip, pick);
    }
};