// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach: 2 choices choose house or not choose. If we choose current house then we can rob any of house left to its previous house, else if we not to choose current house then we can get maximum robbery from all previous houses. So, 2 variables used previous and previousMinusOne, both 0 at start. iterate through houses and currentMaxRobbery = max(previous, previousMinusOne+currHouse) and shift previousMinusOne to previous and previous to currentMaxRobbery. currentMaxRobbery will hold answer after loop.

public class HouseRobber {

    //Approach 1- Dynamic programming   TC=O(n), SC=O(n)
    // public int rob(int[] nums) {
    //     int n = nums.length;    //getting size of input array
    //     if(n == 0)    return 0; //return 0 if empty input array

    //     int[] dp = new int[n + 1];  //creating array to store max money robbed so far
    //     dp[0] = 0;  //initialize to 0 since no houses to rob so far
    //     dp[1] = nums[0];    //initialize to nums[0] since 1st house is robbed

    //     for(int i = 1; i < n; i++) {    //loop through all remaining houses
    //         dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);   //calculate max money so far as maximum of current maxValueRobbed from houses and sum of alternate house and current house money
    //     }

    //     return dp[n];   //return max money robbed
    // }

    //Approach 2- Optimized Dynamic programming     TC=O(n), SC=O(1)
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int previous = 0, previousMinusOne = 0;
        //previous means profit if we not to choose current house and profit from previous robberies
        //previousMinusOne means profit before  previous house, which can be used with choosing current house case
        //assume like [previousMinusOne, previous, num, nextNum, ...]
        for(int num: nums) {
            int temp = Math.max(previous, num + previousMinusOne);  //max of not choosing current house and choosing current house + plus sum before previous house
            previousMinusOne = previous;    //update previousMinusOne to previous
            previous = temp;    //update previous to temp for next iteartion
        }
        return previous;    //holds the answer
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();

        int[] houses1 = {1, 2, 3, 1};
        System.out.println("Max robbery for [1,2,3,1]: " + hr.rob(houses1));

        int[] houses2 = {2, 7, 9, 3, 1};
        System.out.println("Max robbery for [2,7,9,3,1]: " + hr.rob(houses2));
    }
}
