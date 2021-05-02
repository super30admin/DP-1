/*
Time complexity - O(N)
Space complexity - O(1)
*/
class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int skip = 0, take = nums[0];
        for (int i = 1; i < nums.size(); ++i){
            int temp = skip;
            skip = max(skip, take);
            take = temp + nums[i];
        }
        return max(skip, take);
    }
};