// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 


// Your code here along with comments explaining your approach
// Idea here is to calculate amount robbed in each scenario as maximum between previously obtained
// amount and amount that has been achieved two steps back(coz if we didnt take one before which means we 
// need to take amount from 2 steps before). Return the current for max value.

#include <vector>

class Solution {
public:
    int rob(std::vector<int>& nums) {
        int n = nums.size();
        if(n == 0)
        {
            return 0;
        }
        if (n < 2)
        {
            return nums[0];
        }

        int prev = nums[0];
        int curr = std::max(nums[0], 0+ nums[1]);

        //iterate over the nums array and calculate the amount of money in each case
        for(int i = 2; i < n; i++)
        {
            int temp = curr;
            curr = std::max(curr, (nums[i] + prev));
            prev = temp;
        }

        return curr;
        
    }
};