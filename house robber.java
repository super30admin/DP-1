time complexity: O(n)
space complexity: O(1)

class Solution { //dynamic progranmming
    public int rob(int[] nums) {
       if(nums==null||nums.length==0) //initial check
        return 0;
 
    if(nums.length==1) //if there is only one element, return that
        return nums[0];
 
    int[] dp = new int[nums.length]; //creating a result array
    dp[0]=nums[0]; //putting the first element in result array
    dp[1]=Math.max(nums[0], nums[1]); //taking max of first and second, putting it in result
 
    for(int i=2; i<nums.length; i++){ //for loop over n-2 elements
        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]); //putting the max value
    }
 
    return dp[nums.length-1]; //returning the last element
    }
}