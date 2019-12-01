//DP optimized with 2 variables to hold previous values; not using matrix
class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0) return 0;
        int chosen = 0;
        int not_chosen = 0;
        for (int i = 0; i < nums.size(); i++){
            int temp = chosen;
            chosen = not_chosen + nums[i];
            not_chosen = std::max(temp, not_chosen);
        }

        return std::max(chosen, not_chosen);
    }
};


//time complexity: O(n)
//Space complexity: O(n)
