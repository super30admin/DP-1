//198. House Robber

/*
Greedy wont work - when you have [2,1,1,2]
Exhaustive solution is one way but it exceeds time
DP: Take maximum of robAmount till prev house and current house + robAmount two houses behind
=> max(dp[i-1], nums[i]+dp[i-2]);
*/

class Solution {
public:
    int rob(vector<int>& nums) {
    /*
        //greedy - wont work always
        int fRob = 0, sRob = 0;
        for(int i=0;i<nums.size();i+=2){
            fRob += nums[i];
        }
        for(int i=1; i<nums.size(); i+=2){
            sRob += nums[i];
        }

        return max(fRob,sRob);
    */
    
    /*
    //exhaustive -- time limit exceeds
    if(nums.size() == 0) return 0;
    if(nums.size() < 2) return nums[0];

    return helper(nums,0,0);
    */

    /*
    //dp
    //TC: O(n)
    //SC: O(n)
    int n= nums.size();
    if(n == 0) return 0;
    if(n < 2) return nums[0];
    vector<int> dp(n);
    dp[0]=nums[0];
    dp[1] = max(nums[0], 0+nums[1]);

    for(int i=2; i<n;i++){
        dp[i] = max(dp[i-1], nums[i]+dp[i-2]);
    }

    return dp[n-1];
    */
    
    //dp - space optimization
    //TC: O(n)
    //SC: O(1)
    int n= nums.size();
    if(n == 0) return 0;
    if(n < 2) return nums[0];
    int prev = nums[0];
    int curr = max(prev, 0+nums[1]);

    for(int i=2; i<n;i++){
        int temp = curr;
        curr = max(curr,nums[i]+prev);
        prev = temp;
    }   
    return curr;
    }

    /*
    int helper(vector<int>& nums, int idx, int robAmt){

        //base
        if(idx >= nums.size()) return robAmt;
        //logic   
        //choose     
        int case1 =  helper(nums, idx+2, nums[idx]+robAmt);
        //not choose
        int case2 = helper(nums, idx+1, robAmt);

        return max(case1,case2);
       
    }
    */
};