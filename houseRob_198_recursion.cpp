class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0){
            return 0;
        }
        return helper(nums, 0, 0);
    }
    int helper(vector<int>& nums, int index, int money){
        if(index >= nums.size())
            return money;
        
        int case1 = helper(nums, index+1, money);
        int case2 = helper(nums, index+2, money+nums[index]);
        return max(case1, case2);
    }
};
