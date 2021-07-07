// Time Complexity :    O(N*2)      //itirating through matrix (nums*colum)
// Space Complexity :   O(N*2)      //Because creating matrix of cells N*2
// Did this code successfully run on Leetcode : YES

import java.util.*;
class Main{
  public static void main(String []args){
    int []nums={2,5,6,7,1,0};
    System.out.println("The max amount is : "+findMax(nums));
  }
  private static int findMax(int []nums){
    if(nums==null || nums.length==0){
      return 0;
    }
    int [][]dp=new int[nums.length][2];
    dp[0][1]=nums[0];
    for(int i=1;i<nums.length;i++){
      dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
      dp[i][1]=dp[i-1][0]+nums[i];
    }
    return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
  }
}