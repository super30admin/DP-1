//TC: O(N);
//SC: O(1);

class Solution {
    public int rob(int[] nums) {
        if(nums ==null || nums.length==0){
            return 0;
        }
        
        int dp[][]=new int[nums.length][2];
        
        dp[0][1]=nums[0];   //setting to rob the first house as nums[0];
        
        //select the one max, from previous, since not selecting and the one which              is prev not selected can still be greater then previous selected;
        int skip=0;
        int take=nums[0];
        
        for(int i=1;i<nums.length;i++){
            // dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            // dp[i][1]=dp[i-1][0]+nums[i];
            
            int tempSkip=skip;
            skip=Math.max(skip,take);
            take=tempSkip+nums[i];
        }
        
        return Math.max(take,skip);
        // return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        
    }
}
