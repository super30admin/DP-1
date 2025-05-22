// Time Complexity: O(2^n)
// - At each index, two recursive calls are made: index+1 and index+2
// - This leads to an exponential number of calls as the tree branches out

// Space Complexity: O(n)
// - Due to the recursion stack (in the worst case, the depth goes up to n)


class Solution {
public:

    int helper(vector<int>& nums, int index) {
        if(index >= nums.size()) return 0;

        int case1 = helper(nums,index+1);
        int case2 = nums[index] + helper(nums,index+2);

        return max(case1,case2);
    }

    int rob(vector<int>& nums) {

        return helper(nums,0);
    }
};
