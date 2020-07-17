class House_Robber {
    public int rob(int[] nums) {
    	//Approach:1. Either the robber can rob the house or not. 
    	//2. So we build the dp matrix, where for each house the robber will have two columns to say what he will get if he decides to rob the house or not.
    	//For initialization, for the first house if he does not rob, he will get nothing or if robs he will get whatever amount that house has.
    	//3. if he decides not to, then we can choose optimal way from the before house.
    	//4. if he decides to rob, we can add the amount he will get from robbing this house with the amount he will get from not robbing the house before.
        int[][] dp = new int[nums.length][2];
        if(nums == null || nums.length == 0)
            return 0;
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i< nums.length;i++)
        {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i]+dp[i-1][0];
        }
       /* for(int i=0;i< nums.length;i++)
        {
            System.out.println("vali is--"+dp[i][0]+"--"+dp[i][1]);
        } */
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}

//Time Complexity : O(n) where n is the number of houses 
//Space Complexity : O(n) where n is the number of houses 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :