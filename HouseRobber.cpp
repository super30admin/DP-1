// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/* For every house we have two choices either to rob house or skip house.
 * If we skip the house then the max amount we get is max of previous house skip and take amount.
 * If we rob the house then the total robber amount is previous house skip value + current house value.
 * Return the max of take and skip.
 */

class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        
        int skip;
        int take;
        int temp;
        skip = take = 0;
        
        for (int i = 0; i < nums.size(); i++)
        {
            temp = skip;
            skip = max(skip, take);
            take = temp + nums[i];
        }
        return max(skip, take);
    }
};