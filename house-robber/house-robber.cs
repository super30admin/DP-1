public class Solution {
    public int Rob(int[] nums) {
        
        int prev =0;
            int curr =0;
        foreach(int i in nums)
        {
            int temp = curr;
            curr = Math.Max(prev+i,curr);
            prev = temp;
            Console.WriteLine(temp);
            Console.WriteLine(curr);
            Console.WriteLine(prev);
        }
        return curr;
        
    }
}
