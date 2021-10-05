class Solution {
public:
    int rob(vector<int>& nums) {
        int m = nums.size();
        int n = 2;
        
        int dp[m][n];
        
        // First Column is Choosing to rob the house
        // Second Column is choosing NOT to rob the house
        
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                // Rob the house
                if(j==0){
                    dp[i][j] = dp[i-1][1] + nums[i];
                }
                // NOT rob the house
                else{
                    dp[i][j] = max(dp[i-1][0], dp[i-1][1]);
                }
            }
        }
        
        return max(dp[m-1][0], dp[m-1][1]);
    }
};

// TC: O(2*n) where n is the number of houses
// SC: o(2*n)
