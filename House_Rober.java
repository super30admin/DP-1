/*
    Recursive bruteforce Soltuion :
        We will generate binary tree for each of the house and we have two choice at eachl
        level Either we rob the house or we dont robe the house
        
    time  Complexity : n*(2*n)  n is no of house
    space complexity : recursive stack depth O(N)
    Is worked on leetcode : NO Time Limit Exceeded





*/

public class House_Rober {
    /*
        Dp solution 
        we are mainting Dp [][] array for mainting the amount maximum robbed till date.
        time complexity : O(N)
        Space Complexity :O(N*2) = O(N)
        is worked on leetcode : YES
    */
        
    public int rob_dp(int []nums){
        if (nums == null || nums.length == 0 ){
            return 0;
        }

        int dp[][]  = new int[nums.length][2];
        dp[0][1] = nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return dp[nums.length][1];
    }
    public int rob_recrusive_bruteforce(int[] nums) {
        if (nums == null || nums.length ==0 ) return 0; 
        return helper(nums,0,0);
    }
    
    public int helper(int[] nums, int amt, int index){
        
        if (index >= nums.length ) return amt;
        
//          when you dontchoose it
        int case1 = helper(nums, amt, index+1);
        // when you choose the hourse then next you cant choose adjacent house so update index by 2

        int case2 =  helper(nums, amt +  nums[index], index +2);
        
        return Math.max(case1, case2);
        
    }
    
}