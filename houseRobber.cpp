/* ################################################## Recursive Solution ################################################## */

class Solution {
public:
    int helper(vector<int>& nums, int idx)
    {
        if (idx >= nums.size()) {
            return 0;
        }

        int left = 0, right = 0;
        left += helper(nums, idx + 1);
        right += nums[idx] + helper(nums, idx + 2);

        return max(left, right);
    }
    int rob(vector<int>& nums)
    {
        return helper(nums, 0);
    }
};


/* ################################################## DP Solution ################################################## */

class Solution {
public:
    int rob(vector<int>& nums)
    {
        int prev = 0, cur = 0;

        for (int i = 0; i < nums.size(); i++) {
            int temp = cur;
            cur = max(cur, nums[i] + prev);
            prev = temp;
        }

        return cur;
    }
};
