/*
Time complexity: O(n)
Space Complexity: O(1)
Solution got accepted on Leetcode: Yes
Any difficulties: No

Approach:
1. As we know two adjacent houses have same security system, so to avoid adjacency we can iterate houses in even or odd index
2. We can sum up values at even and odd indexes and can return which ever value is greater
3. For every odd and even iteration we will update out even and odd variable with the great value in order to maximise the
robbing sum
 */
public class HouseRobber {
    public static int houseRobbing(int[] nums){
        int even = 0;
        int odd = 0;

        for(int i = 0; i<nums.length; i++){
            if(i%2 == 0){
                even+= nums[i];
                even = even>odd ? even : odd;
                System.out.println("Even: "+ even);
            }else{
                odd+= nums[i];
                odd = odd>even ? odd: even;
                System.out.println("odd: "+ odd);
            }
        }
        return odd>even ? odd: even;
    }

    public static void main(String[] args){
        int arr[] = {2,1,1,2};

        System.out.println("Maximum Value after robbing: "+ houseRobbing(arr));
    }
}
