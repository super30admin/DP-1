// Time Complexity : O(n^2) - since also has to find max
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. DP: Maintain cache array with all 0s and single loop and iterate through the house values
// 2. At each house, check if current cache value is bigger than sum of current house value and max of cache values so far but not considering previous house value
// 3. Return max of last two elements since either last one is present in the solution set or not

class Solution {
public:
    int rob(vector<int>& nums) {
        if(!nums.size()) return 0;
        vector<int> cache(nums.size()+1, 0);
        cache[1] = nums[0];
        for(int i=2; i<=nums.size(); i++){
            cache[i] = max(cache[i], nums[i-1]+*max_element(cache.begin(), cache.begin()+i-1));
        }
        return max(cache[nums.size()-1], cache[nums.size()]);
    }
};