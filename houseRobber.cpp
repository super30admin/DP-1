// Time Complexity : O(N) where N --> number of houses
// Space Complexity : O(2N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
public:
    int rob(vector<int>& nums) {
        vector<vector<int>> dp(nums.size(), vector<int>(2,0));
        if(nums.size()==0)
            return 0;
        int dont = 0;
        int take = nums[0];
        int temp;
        int i=1;
        for(i=1;i<nums.size();i++)
        {
            temp = dont;
            dont = max(dont,take);
            take = temp + nums[i];
        }

        return max(dont,take);

    }
};
