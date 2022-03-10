public class Rob {
  /**
   * 
   * Time Complexity: O(n)
   * Space Complexity: O(n)
   * 
   * Any Problems solving this? No
   * Were you able to solve it on leetcode? Yes
   */
  public int rob(int[] nums) {
    int[] memo = new int[nums.length];
    
    if(nums.length == 0) { return 0; }
    if(nums.length == 1) { return nums[0]; }
    if(nums.length == 2) { return Math.max(nums[0], nums[1]); }
    if(nums.length == 3) { return Math.max(nums[0]+nums[2], nums[1]); }
    
    memo[0] = nums[0];
    memo[1] = nums[1];
    memo[2] = nums[0]+nums[2]; 
    
    for(int i = 3; i < nums.length; i++){
        memo[i] = nums[i] + Math.max(memo[i-2], memo[i-3]);
    }
    
    return Math.max(memo[nums.length-1], memo[nums.length-2]);
  }
}
