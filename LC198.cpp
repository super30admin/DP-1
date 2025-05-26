// Time complexity O(n)
// SPace complexity O(1)
class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }
        int n = nums.size();
        int prev = 0;
        int curr = nums[0]; 
        for (int i=1; i < nums.size(); i++) {
            int result = 0;
            if (i == 1) {
                result = max(curr, nums[i]);
            } else {
                result = max(curr, nums[i] + prev);
            }
            prev = curr;
            curr = result;
        }
        return curr;
    }
};