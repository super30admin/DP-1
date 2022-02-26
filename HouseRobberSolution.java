// Time Complexity : O(n) // iterate through each integer in array
// Space Complexity : O(1) // only additional space for the variables, which are constant space 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class HouseRobberSolution {
    public int rob(int[] nums) {
        int RobPrev = 0;
        int notRobPrev = 0;
        
        for (int i = 0; i < nums.length; i++){
            int RobCurr = notRobPrev + nums[i];
            int notRobCurr = Math.max(RobPrev, notRobPrev); // just because you don't rob the current, does not mean you robbed the prev --> take the best option between if you did rob the prev or didn't rob the previous
                
            // update variables
            RobPrev = RobCurr;
            notRobPrev = notRobCurr;
        }
        
        return Math.max(RobPrev, notRobPrev); // treat as two subproblems (one route you did rob prev vs you did not rob prev and take best option)
    }
}