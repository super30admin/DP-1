

public class HouseRobber {

    //Time complexity : O(n)
    //Space complexity : O(1) 
    //works on leetcode

    public static void main(String[] args)
    {
        int[] nums = {1,2,4,3,0,1,2,3,5};
        System.out.println("Max by robbing houses" + rob(nums));
    }

    public static int rob(int[] nums) {
        
        if(nums == null || nums.length == 0) return -1;
    
        if(nums.length<2) return nums[0];
    
        int prev = nums[0];
        int curr = Math.max(nums[1], prev);    
    
        for(int i=2;i<nums.length;i++)
        {
            int temp = curr;
            curr = Math.max(nums[i] + prev,curr);
            prev = temp;
        }
    
        return curr;
        }
}
