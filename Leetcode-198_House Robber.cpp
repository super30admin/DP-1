// Time Complexity : O(N) where N = size of nums.
// Space Complexity :  O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
1. Come up with recursive solution
2. Build up dp table
3. return the result
*/

class Solution
{
public:
    int rob(vector<int>& nums)
    {
        int len = nums.size();
        if (len == 1)
            return nums[0];

        if (len == 2)
            return max(nums[0], nums[1]);

        vector<vector<int>>dp(2, vector<int>(len, 0)); // first row corresponds to object not included
        // second when item is included.


        dp[1][0] = nums[0];
        dp[0][1] = nums[0];
        dp[1][1] = nums[1];

        for (int i = 2; i < len; i++)
        {
            // when current item is not included, get max from (n-1) items.
            dp[0][i] = max(dp[1][i - 1], dp[0][i - 1]);
            // when current item is included
            dp[1][i] = nums[i] + dp[0][i - 1];
        }
        return max(dp[0][len - 1], dp[1][len - 1]);
    }

};


// TC - O(2^N)

// recursive solution
   /* int rob(vector<int>& nums)
    {
        if(nums.size()==1)
            return nums[0];

        int res=0;
        return robhelper(nums, res, 0);
    }

    int robhelper(vector<int>nums, int current_sum, int index)
    {
        // base case
        if(index>=nums.size())
            return current_sum;

        // logic
        return max(robhelper(nums, current_sum + nums[index] , index+2), robhelper(nums, current_sum , index+1) );

    }
};*/




















// recursive solution
/*int rob(vector<int>& nums) 
    {
        if(nums.size()==1)
            return nums[0];
        
        int res =0;
        return robhelper(nums, res, nums.size()-1);
    }
    
    int robhelper(vector<int>nums, int current_sum, int index)
    {
        // base case
        if(index<0)
            return current_sum;
        
        // logic
        return max(robhelper(nums, current_sum + nums[index] , index-2), robhelper(nums, current_sum , index-1) );
 
    }
/*