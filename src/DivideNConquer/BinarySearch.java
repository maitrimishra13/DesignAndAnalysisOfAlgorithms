package DivideNConquer;

import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] A, int low, int high, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == key)
                return mid;
            else if (A[mid] < key)
                return binarySearch(A, mid + 1, high, key);
            else
                return binarySearch(A, low, mid - 1, key);
        }
        return -1;
    }

    public static int[] create(int n, Scanner sc) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.print("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Enter array elements: ");
        int[] arr = create(n, sc);

        System.out.print("Enter the number to be searched : ");
        int x = sc.nextInt();

        int ans = binarySearch(arr, 0, n - 1, x);
        if (ans == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("The number is found at index " + ans);
        }
    }
}