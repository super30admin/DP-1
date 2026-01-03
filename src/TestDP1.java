import java.util.Arrays;

public class TestDP1 {
    public static void main(String[] args) {

        CoinChange cc = new CoinChange();

        int[][] coinsList = {
                {1, 2, 5},
                {2},
                {1},
                {1, 3, 4}
        };
        int[] amounts = {11, 3, 0, 6};
        int[] expectedCC = {3, -1, 0, 2};

        for (int i = 0; i < coinsList.length; i++) {
            int r1 = cc.recursiveCoinChange(coinsList[i], amounts[i]);
            int r2 = cc.coinChangeTopDown(coinsList[i], amounts[i]);
            int r3 = cc.coinChange2D(coinsList[i], amounts[i]);
            int r4 = cc.coinChange1D(coinsList[i], amounts[i]);

            System.out.println(
                    r1 == expectedCC[i] &&
                            r2 == expectedCC[i] &&
                            r3 == expectedCC[i] &&
                            r4 == expectedCC[i]
            );
        }
        System.out.println("Testing House Robber");

        HouseRobber hr = new HouseRobber();

        int[][] robberTests = {
                {2, 7, 9, 3, 1},
                {1, 2, 3, 1},
                {2, 1, 1, 2},
                {1},
                {}
        };

        int[] expectedHR = {12, 4, 4, 1, 0};

        for (int i = 0; i < robberTests.length; i++) {
            int a = hr.robRecursive(robberTests[i]);
            int b = hr.robTopDown(robberTests[i]);
            int c = hr.robBottomUp(robberTests[i]);
            int d = hr.robOptimized(robberTests[i]);

            System.out.println(
                    a == expectedHR[i] &&
                            b == expectedHR[i] &&
                            c == expectedHR[i] &&
                            d == expectedHR[i]
            );
        }
    }
}
