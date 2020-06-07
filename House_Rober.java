/*
    Recursive bruteforce Soltuion :
        We will generate binary tree for each of the house and we have two choice at eachl
        level Either we rob the house or we dont robe the house
        
    time  Complexity : n*(2*n)  n is no of house
    space complexity : recursive stack depth O(N)
    Is worked on leetcode : NO Time Limit Exceeded


_______________________________________________________________________________________________
        Dp solution 
        we are mainting Dp [][] array for mainting the amount maximum robbed till date.
        time complexity : O(N)
        Space Complexity :O(N*2) = O(N)
        is worked on leetcode : YES

____________________________________________________________________________________________________
        DP constant space solution
        time complexity :O(N)
        space complexity : O(1)
        is worked on leetcode : YES


________________________________________________________________________________________________
    */
    




public class House_Rober {
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
    
    /*
    Dp solution with O(N) space 
    */
        
    public int rob_dp(int []nums){
        if (nums == null || nums.length == 0 ){
            return 0;
        }

        int dp[][]  = new int[nums.length][2];
        dp[0][1] = nums[0];

        for(int i=1;i<nums.length;i++){
            //  if we are not choosing the perticular house then set current house maximum
            // to the maximum availabel till date ( before current house which we are not robbin)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            // if we are robbing perticular house then we could not have robbed previous house. 
            // and we have maximum robbed amount for previous house had it not been robbed.
            // so we will add that amount with current house amount to get maximum robbed amout till this
            // current house
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
    
    // lets improve our previous dp linear space solution to constant space

    public int rob_constant_space(int nums[]){
        if (nums == null || nums.length == 0 ){
            return 0;
        }
        // skip to store the maximum robbed amount if we are not choosing the house
        int skip = 0;
        // take to store the maximum robbed amount if we are  choosing the house to rob
        int take = nums[0];
        int temp;
        for(int i=1;i<nums.length;i++){
            temp = skip;
            skip  = Math.max(temp,take);
            take = temp +  nums[i];
        }
        return Math.max(take,skip);
    }
}