import java.util.Arrays;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Problem2 {
	  int[] memo;
	  public int rob(int[] nums) {
	      memo = new int[nums.length + 1];
	      Arrays.fill(memo, -1);
	      return rob(nums, nums.length - 1);
	  }
	      private int rob(int[] nums, int i) {
	      if (i < 0) {
	          return 0;
	      }
	      if (memo[i] >= 0) {
	          return memo[i];
	      }
	      int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
	      memo[i] = result;
	      return result;
	  }
}
