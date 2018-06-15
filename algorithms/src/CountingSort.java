import java.util.Scanner;

/**
 * Created by mystery on 13.10.2017.
 */

public class CountingSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, i;

        System.out.println("Enter size of Array: ");
        n = scan.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements: ");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();

        countingSort(arr);

        System.out.println("Elements after sorting ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void countingSort(int[] arr) {
        int n = arr.length;

        int max = arr[0], min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        int range = max - min + 1;

        int[] count = new int[range];
        for (int i = 0; i < n; i++)
            count[arr[i] - min]++;
        for (int i = 1; i < range; i++)
            count[i] = count[i] + count[i - 1];
        for (int i = 0, j = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }
}