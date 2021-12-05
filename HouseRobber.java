class HouseRobber {
    /*
    
    1. Recursive Solution 
       TC : Exponential
       At every step we have two choices whether to choose the house or not
       if we choose the house we have to check if we can select the next to next house
       if we dont choose the house we can check if we can choose the next house
       
    public int rob(int[] nums) {
      if(nums==null || nums.length==0) return 0;
       return helper(nums,0,0); 
    }
    
    private int helper(int nums[],int index,int amtGained){
        if(index>=nums.length) return amtGained;
        
        int case1=helper(nums,index+1,amtGained);
        int case2=helper(nums,index+2,amtGained+nums[index]);
        
        return Math.max(case1,case2);
    }
    
    */
    
    /*
    
    2. DP solution with 2D array
       TC: O(n) where n is the length of nums
       SC: O(n) where n is the length of nums
    
    
     public int rob(int[] nums) {
      if(nums==null || nums.length==0) return 0;
         
      int dp[][]=new int[nums.length][2];
         
      dp[0][0]=0;
      dp[0][1]=nums[0];
         
      for(int i=1;i<dp.length;i++){
          dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
          dp[i][1]=dp[i-1][0]+nums[i];
      }   
      return Math.max(dp[nums.length-1][1],dp[nums.length-1][0]);
    }
    
    */

    /*
     3.
        DP solution wiyh two pointers
        TC: O(n) where n is the size of nums
        SC: O(1)

     */
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int skip=0;
        int take =nums[0];
        for(int i=1;i<nums.length;i++){
            int prevSkip=skip;
            skip=Math.max(skip,take);
            take=prevSkip+nums[i];
        }
        return Math.max(skip,take);
    }
}