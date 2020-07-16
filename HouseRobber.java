/*
Recursive Approach
// Time Complexity : 2^n
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :Yes
// Your code here along with comments explaining your approach
if we have robbed one house we can not rob adjancent house. at every house We would be making decision that whether to rob house or not. If we rob the house we would then we recursively exploring house next to the adjancent house(index+2) and if we dont choose we would  recursively explore from adjancent house
*/

// class Solution {
//     public int rob(int[] nums) {
//         return robUtil(nums, 0, 0);
//     }
//     public int robUtil(int[]nums, int index, int max){
//         //base case
//         if(index >= nums.length)
//             return max;
//         //choose the house
//         int case1 = robUtil(nums, index+2 , max+nums[index]);
//         // dont choose the house
//         int case2 = robUtil(nums, index+1, max);
//         return Math.max(case1, case2);
//     }
// }
/*      [1,2,3,1,6] 
[3,1,6]        [2,3,1,6]    
[6] [1,6]     [3,1,6] [1,6]

Repeated sub problems
*/


/*
DP Approach
// Time Complexity : O(n*2) where n is number of houses
// Space Complexity : O(n*2)
// Did this code successfully run on Leetcode :Yes
// Your code here along with comments explaining your approach
1. Overlapping subproblems in the above approach can be memoized using dynamic programming. 
2. When we rob the current house that means we must not have robbed prev house. So max robbery till here will be prev house not choose amount + current house amount
3. If we are choosing current house then maximum robbery till here would be max of prev house choosen and not choosen 
*/

// class Solution {
//     public int rob(int[] nums) {
//         int dp[][] = new int[nums.length+1][2];
//         for(int i=1; i < dp.length; i++){
//             for(int j=0; j < dp[0].length; j++){
//                 //dont choose this house.
//                 dp[i][0] = Math.max( dp[i-1][0], dp[i-1][1]);
//                 //choose this house.
//                 dp[i][1] = dp[i-1][0]+ nums[i-1];
//             }
//         }
//         return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
//     }
// }

/*
DP Approach without using dp array
// Time Complexity : O(n) where n is number of houses
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Your code here along with comments explaining your approach
We can improve the above dp approach using only two variables choose or not choose.
*/
class Solution {
    public int rob(int[] nums) {
        int choosen = 0, notChoosen=0;
        for(int i=0; i < nums.length; i++){
            int choosen_temp = choosen;
            choosen = notChoosen+ nums[i];
            notChoosen = Math.max(notChoosen , choosen_temp);
        }
        return Math.max(choosen,notChoosen);
    }
}

