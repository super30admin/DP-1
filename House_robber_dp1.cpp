//DP Approach 1 with O(n) time and space complexity
class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0) return 0;
        int n = nums.size();
        int dp[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2; j++){
                if(j == 0){                             //house not chosen
                    dp[i][j] = std::max(dp[i-1][0], dp[i-1][1]);
                }else{                                     //house is chosen
                    dp[i][j] = dp[i-1][0] + nums[i];
                }
            }
        }
        int m = sizeof(dp)/ sizeof(dp[0]);             
        return std::max(dp[m-1][0], dp[m-1][1]);
    }
};

//Time complexity : O(n)
//Space Complexity: O(n)
