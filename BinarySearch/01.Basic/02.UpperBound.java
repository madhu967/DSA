public class Main {

    public static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 3, 4, 5};

        System.out.println(upperBound(arr, 2)); 
    }
}
