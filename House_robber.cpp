class Solution {
public:
    int rob(vector<int>& nums) {
   
        int dp[nums.size()];
        if(nums.size()<2) return nums[0];
        dp[0] = nums[0];
        dp[1] =  max(nums[0],nums[1]);

        for(int i=2;i<nums.size();i++){
                dp[i] = max(dp[i-1],nums[i]+dp[i-2]);
        }   
        return dp[nums.size()-1];
    }
};

Recursion approch


      
    //         return robber(nums,0,0);
        
    // }


    // int robber(vector<int>& nums,int idx,int money){

    //     if(idx>nums.size()-1){
    //         return money;
    //     }

        
    //     money = money+nums[idx];
    //     int case1 = robber(nums,idx+2,money);
    //     int case2 = robber(nums,(idx+2)+1,money);

    //     int k = max(case1,case2);

    //     return k;

        
    // } 