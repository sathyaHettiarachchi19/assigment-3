import java.util.Arrays;
import java.util.Random;

public class BinarySearchAnalyzer {
    public static void main(String[] args) {
        int[] sizes = { 100, 500, 1000 };
        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);
            Arrays.sort(arr); // must sort before binary search
            int target = arr[new Random().nextInt(size)];

            long start = System.nanoTime();
            binarySearch(arr, target);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f%n", size, timeMs);
        }
    }

    static int[] generateArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = r.nextInt(10000);
        return arr;
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
