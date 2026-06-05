public class KnapsackLogistics {

    public static void main(String[] args) {

        // Consignment Names
        String[] items = {
                "A", "B", "C", "D",
                "E", "F", "G", "H"
        };

        // Weights in tons
        int[] weight = {
                5, 8, 3, 10,
                4, 6, 7, 2
        };

        // Values in ₹ thousand
        int[] value = {
                40, 50, 20, 70,
                30, 35, 45, 15
        };

        int n = items.length;
        int capacity = 24;

        // DP Table
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++) {

            for (int w = 0; w <= capacity; w++) {

                // Skip item if overweight
                if (weight[i - 1] > w) {

                    dp[i][w] = dp[i - 1][w];
                }

                else {

                    // Maximum of take or skip
                    dp[i][w] = Math.max(
                            dp[i - 1][w],

                            dp[i - 1][w - weight[i - 1]]
                                    + value[i - 1]
                    );
                }
            }
        }

        // Maximum value
        System.out.println(
                "Maximum Payment = ₹"
                        + dp[n][capacity] + "k");

        // Find selected items
        int w = capacity;

        System.out.println("\nSelected Consignments:");

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                System.out.print(items[i - 1] + " ");

                w = w - weight[i - 1];
            }
        }
    }
}