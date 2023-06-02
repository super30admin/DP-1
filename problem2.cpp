# Time Complexity : O(n) where n = length of array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution {
public:
    int rob(vector<int>& nums) {
        int prev2 = 0, prev = 0, cur = 0;
        for(auto i : nums) {
            cur = max(prev, i + prev2);
            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
};