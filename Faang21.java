// time Complexity : O(n)
// space Complexity :  O(1)
// Leetcode : yes

package leetcode;
public class Faang21 {
    public int rob(int[] nums) {
        int skip = 0; int take = nums[0];
        int numslen=nums.length;
        for(int i=1;i<numslen;i++){
            int prevskip = skip;
            skip = Math.max(skip, take);
            take = prevskip+nums[i];
        }
        return Math.max(skip,take);
    }
}