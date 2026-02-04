package DivideNConquer;

import java.util.Scanner;

public class MaxProfit {

    public static int maxProfitBruteForce(int[] prices) {
        //Time: O(n²)
        //Space: O(1)

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static int maxProfitDnC(int[] prices) {
        //Time: O(n log n)
        //Space: O(log n) (recursion stack)

        return maxProfitDnC(prices, 0, prices.length - 1);
    }

    private static int maxProfitDnC(int[] prices, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left + right) / 2;

        int leftProfit = maxProfitDnC(prices, left, mid);
        int rightProfit = maxProfitDnC(prices, mid + 1, right);

        int minLeft = Integer.MAX_VALUE;
        for (int i = left; i <= mid; i++) {
            minLeft = Math.min(minLeft, prices[i]);
        }

        int maxRight = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            maxRight = Math.max(maxRight, prices[i]);
        }

        int crossProfit = maxRight - minLeft;

        return Math.max(Math.max(leftProfit, rightProfit), crossProfit);
    }

    public static int maxProfitOptimized(int[] prices) {
        // Time: O(n)
        // Space: O(1)

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        //int[] prices = {7, 1, 5, 3, 6, 4};

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println("\nBrute Force Profit: " + maxProfitBruteForce(prices));
        System.out.println("Divide & Conquer Profit: " + maxProfitDnC(prices));
        System.out.println("Optimized Profit: " + maxProfitOptimized(prices));

        sc.close();


    }
}
