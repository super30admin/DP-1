//Time Complexity:O(n) length of array
//Space Complexity: (O1) as we have mutated the array
public class Solution {
    public int Rob(int[] nums){
     if(nums == null || nums.Length ==0){
      return 0;
      }
     int[,] dp = new int[nums.Length,2];
     dp[0,1] = nums[0];
     for(int i = 1; i< nums.Length; i++){
      dp[i,0] = Math.Max(dp[i-1,0], dp[i-1,1]);
      dp[i,1] = dp[i-1,0] + nums[i];
      }
     
      return Math.Max(dp[dp.GetLength(0) - 1, 0], dp[dp.GetLength(0) - 1, 1]);
    }
}