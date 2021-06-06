class Solution {
    public int rob(int[] nums) {
      //recursive approach
      //null case
      if(nums.length == 0 || nums == null) return 0;
      return helper(nums,0,0);
        
    }
  private int helper(int nums[], int index, int robbedAmount) {
    //base
    if(index >= nums.length) {
      return robbedAmount;
    }
    
    //logic
    //choose to rob
    int case1 =  helper(nums, index+2, robbedAmount+nums[index]);
    
    // dont choose
    int case2 = helper(nums, index+1, robbedAmount);
    
    return Math.max(case1,case2);
  }
}