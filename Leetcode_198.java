//Way:1
//Recurssion-- choose or no choose
//TC: 2^(O(n))
class Solution {
    public int rob(int[] nums) {
        return helper(nums,0);
        
    }

    private int helper (int[] nums, int idx){
        //base case
        if(idx>=nums.length) return 0;

        //logic
        //no choose
        int case1=helper(nums,idx+1);
        //choose
        int case2=nums[idx]+helper(nums,idx+2);

        return Math.max(case1,case2);

    }
}

//Way:2
//Recurssion-- choose or no choose -- causing time limit exceeded
//So, going with memoization-- remembering the result
//TC: O(n)
class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        return helper(nums,0,memo);
        
    }

    private int helper (int[] nums, int idx, int[] memo){
        //base case
        if(idx>=nums.length) return 0;

        if(memo[idx]!=0) return memo[idx];

        //logic
        //no choose
        int case1=helper(nums,idx+1,memo);
        //choose
        int case2=nums[idx]+helper(nums,idx+2,memo);
        memo[idx]=Math.max(case1,case2);

        return Math.max(case1,case2);

    }
}

//Way:3
//Recurssion-- choose or no choose -- causing time limit exceeded
//So, going with memoization-- remembering the result
//TC: O(n)
class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        //TO avoid time limit exceeded for the input with all elements as 0
        for(int i=0;i<nums.length;i++){
            memo[i]=Integer.MIN_VALUE;
        }
        return helper(nums,0,memo);
        
    }

    private int helper (int[] nums, int idx, int[] memo){
        //base case
        if(idx>=nums.length) return 0;

        if(memo[idx]!=Integer.MIN_VALUE) return memo[idx];

        //logic
        //no choose
        int case1=helper(nums,idx+1,memo);
        //choose
        int case2=nums[idx]+helper(nums,idx+2,memo);
        memo[idx]=Math.max(case1,case2);

        return Math.max(case1,case2);

    }
}

//Way4:
//DP: tabulation
//We are choosing alternate houses. We can have one dp array which holds maximum value at that particular index
//At every index we have two options. To choose the house or not to choose the house
//Choose the house: sum of curr house and max value at (curr house -2)
//Not to choose the house: Max value at prev house i.e., currhouse-1
//Choose max value from above steps
//TC: O(n); SC: O(n)
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[n-1];

    }
}
