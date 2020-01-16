// Time Complexity : One for loop iterating over the nums array so Asymtotically O(m)
// Space Complexity : O(m) for the auxillary 2D Dp array since we know columns cannot exceed 2
// Any problem you faced while coding this : None

// Your code here along with comments explaining your approach

 import java.util.*;
class HouseRobber {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2]; //columns are two in the dp auxillary array becuase we know robber can either rob the house or not rob it
        int m = dp.length;
        dp[0][0] = 0;  
        dp[0][1] = 0;
        for(int i = 1; i < m; i++)
        { //for all houses, if robber robs the house add cost of robbing that house with previous house cost of not robbing. If not robbing house, take maximum of previous robbing and not robbing
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i - 1];
        }
    return Math.max(dp[m-1][0], dp[m-1][1]); //finally when he reaches last house take maximum of robbing it and not robbing it
    }
}

//Main Class
class Main
{
    public static void main(String[] args)
    {
    HouseRobber obj = new HouseRobber();
    int[] nums = {1, 2, 3, 1}; 
    System.out.print("Maximum robbery that a robber can do on the input array  " + Arrays.toString(nums) + " is " + obj.rob(nums));  
    System.out.print("\n");
    }
}