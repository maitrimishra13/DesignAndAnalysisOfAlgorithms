package DivideNConquer;

public class MaxSubArraySum {
    public static int maxSubArraySum(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = (left + right) / 2;

        int leftMax = maxSubArraySum(arr, left, mid);
        int rightMax = maxSubArraySum(arr, mid + 1, right);
        int crossMax = maxCrossingSum(arr, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static int maxCrossingSum(int[] arr, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i = mid; i >= left; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        return (leftSum + rightSum);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -5, 6, -2, -3, 1, 5, -6};

        int maxSum = maxSubArraySum(arr, 0, arr.length - 1);
        System.out.println("Maximum Subarray Sum = " + maxSum);
    }
}
