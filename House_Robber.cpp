class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n ==0)return 0;
        if(n<2)return nums[0];
        int *dp = new int[n];
        dp[0]=nums[0];
        dp[1]= max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i]= max(dp[i-1], nums[i]+dp[i-2]);
        }
    return dp[n-1];
    }
};
// Right now the time and space complexity are O(n) but we can further reduce the space complexity to O(1) by just using two variables like prev and current
