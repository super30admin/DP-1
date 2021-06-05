// Time Complexity : O(n) incase of dp, exponential O(2^n) for brute force 
// Space Complexity : O(1) for the most efficient solution, O(n) when using a dp array, height of the recursion tree in case of brute force 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
1. We choose a house to rob or we skip that house.
2. case 1: if we skip a house, the maximum robbed amount will be maximum amount robbed before coming to this house.
3. case 2: if we decide to rob a house, we will add the robbed amount to the maximum amount robbed upto the house before the adjacent house.
4. we return the max of case 1 and case 2.
*/



public class HouseRobber {  
    public int rob(int[] nums) {
     

       // return helper(nums,0,0);
        return dpSolution2(nums);
    } 

    public int  dpSolution1(int[] nums)
    {
        int[][] dp=new int[nums.length][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
           
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
                dp[i][1]=dp[i-1][0]+nums[i];

        }

        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);


    }


    public int  dpSolution2(int[] nums)
    {
        int skip=0;
        int rob=nums[0]; 
        for(int i=1;i<nums.length;i++)
        {
               int prevSkip=skip;
               int prevRob=rob;
                skip=Math.max(prevSkip,prevRob);
                rob=prevSkip+nums[i];

        }

        return Math.max(skip,rob);


    }


    public int helper(int[] nums,int index,int robbing)
    {
        if(nums==null||nums.length==0)
        return 0;

        if(index>=nums.length)
        return robbing;

        //logic
        //We will rob a house: rob
        int case1 = helper(nums,index+2,robbing+nums[index]);
        //We will not rob the house: skip
        int case2 = helper(nums,index+1,robbing);

        return Math.max(case1,case2);
    }

    public static void main(String[] args)
    {
        HouseRobber obj=new HouseRobber();
        int[] nums={2,7,9,1,1,8};
        System.out.println(obj.rob(nums));
    }
}
