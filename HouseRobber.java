// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class HouseRobber{
    public static void main(String[] args){
        HouseRobber hb = new HouseRobber();
        int[] houses = {5,2,3,10};
        int result=hb.rob(houses);
        System.out.print("Result: " +result);
    }
    public int rob(int[] nums) {

        if(nums.length==0 || nums == null){
            return 0;
        }

        int C=0;
        int DC=0;

        for(int num: nums){
            int temp = DC;
            DC= Math.max(C,DC);
            C=num+temp;
        }
        return Math.max(C,DC);

    }
}