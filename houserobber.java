//time complexity:O(n) n->number of houses
//space complexity:O(1)
class Solution {
    public int rob(int[] nums) {
        int house1=0;
        int house2=0;
        for(int i=0;i<nums.length;i++){
            int temp=house2;
            house2=Math.max(house2,house1+nums[i]);
            house1=temp;
        }
        return Math.max(house1,house2);
    }
}