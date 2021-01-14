//recursion
class Solution {
public:
    int rob(vector<int>& nums) {
     return helper(nums, nums.size() - 1);
    }

    int helper(vector<int>& nums, int i){
        //base case
        if(i >= nums.size() ) return 0;

        // case
        return std::max(helper(nums, i-2) + nums[i], helper(nums, i-1));
    }


};

//Time complexity: O(2^n)
//Leet Code: Time limit exceeded
