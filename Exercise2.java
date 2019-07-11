class Solution {
    public int rob(int[] nums) {
        int length=nums.length-1;
        int count1=0,count2=0;
        for(int i=0;i<=length;i+=2){count1+=nums[i];}
        for(int i=1;i<=length;i+=2){count2+=nums[i];}
        if(count1>count2){return count1;}
        return count2;
        
    }
}