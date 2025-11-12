import java.util.Random;

public class LinearSearchAnalyzer {
    public static void main(String[] args) {
        int[] sizes = { 100, 500, 1000 };
        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("-----------------------");

        for (int size : sizes) {
            int[] arr = generateArray(size);
            int target = arr[new Random().nextInt(size)]; // pick random element to find
            long start = System.nanoTime();
            linearSearch(arr, target);
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

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target)
                return i;
        return -1;
    }
}
