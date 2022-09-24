// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// // Solution1 :
// // Exhaustive approach trying each combination
// // Works but not time effective

// //     [2  7  9  3  1]

// //     not choose 0 : [7,9,3,1] 0
// //     choose 1:      [9,3,1] 2

// //     not choose 0 : [3,1] 2
// //     choose 1:      [1] 2+9=11

// //     not choose 0 : [] 11
// //     choose 1:      [] 2+9+1=12

// class Solution {
//     public int rob(int[] nums) {
//         if(nums == null || nums.length == 0) return -1;

//         return helper(nums, 0, 0);
//     }

//     private int helper(int[] nums,int index, int amount) {
//         if(index >= nums.length) {
//             return amount;
//         }

//         // in case we not choose the house to rob
//         int case1 = helper(nums, index + 1, amount);

//         // in case we choose the house to rob
//         int case2 = helper(nums, index + 2, amount + nums[index]);

//         return Math.max(case1, case2);
//     }
// }

// // Solution2: DP solution using 2 column matrix

// //     DP formula forming as below

// //     case Not  | case
// //       Choose  | Choose
// //          0    |  1
// //     -------------------
// //     0 |  0    |  0      this case added to adjust boundry condition
// //     2 |  0    |  2+0=2
// //     7 |  2    |  7+0=7
// //     9 |  7    |  9+2=11
// //     3 |  11   |  3+7=10
// //     1 |  11   |  1+11=12
// //     ---------------------
// //         max of|  current +
// //         above |  value at
// //          row  | 0th case row above

// class Solution {
//     public int rob(int[] nums) {
//         if(nums == null || nums.length == 0) return -1;

//         int n = nums.length;
//         int[][] dp = new int[n + 1][2];

//         for(int i = 1; i < n + 1; i++) {
//             // max of above row
//             dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

//             // current value + value at 0th case row above
//             dp[i][1] = nums[i - 1] + dp[i - 1][0];
//         }

//         return Math.max(dp[n][0], dp[n][1]);
//     }
// }

// Solution3: DP similar solution using 2 variables

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int skip = 0;
        int take = 0;

        for(int i = 1; i < n + 1; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = nums[i - 1] + temp;
        }

        return Math.max(skip, take);
    }
}