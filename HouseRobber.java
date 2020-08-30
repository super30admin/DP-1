//Time Complexity- O(1)
//Space Complexity=O(n)
class Solution {
    public int rob(int[] nums) {
        int choose=0;
        int dontChoose=0;
        for(int i=0;i<nums.length;i++)
        {
            int temp=dontChoose;
            dontChoose=Math.max(choose,dontChoose);
            choose=nums[i]+temp;
            
        }
        return Math.max(choose,dontChoose);
        
    }
}