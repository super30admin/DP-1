// class Solution {
//     public int rob(int[] nums) {
// Dp state = max amount that I can earn from 0th to iTh
//        int n  = nums.length;
//         if (n==0) return 0;
//         if (n==1) return nums[0];
//         if (n==2) return Math.max(nums[0], nums[1]);
//         int dp[] = new int[n];
//         dp[0] = nums[0];
//         dp[1] = nums[1];
//         dp[2] = nums[2] + nums[0];


//         for (int i = 3 ; i < n ; i++)
//         {
//             dp[i] = Math.max(dp[i-3], dp[i-2]) + nums[i];

//         }

//         return Math.max(dp[n-1], dp[n-2]);
//     }
// }

//Recursive- > TD approach
// TC : O(2^n)
//SC : O(n)
class Solution
{
    public int rob(int[] nums)
    {

        return rob(nums, 0);
    }

    private int rob(int[] nums, int index)
    {
        //base
        if(index >= nums.length)
        {
            return 0;
        }

        //recurse

        int rob = nums[index] + rob(nums, index+2);
        int nRob = rob(nums,index+1);
        return Math.max(rob, nRob);
    }
}