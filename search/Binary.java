package search;

/**
 * Write a description of class Binary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Binary
{

    /**
     * Returns the index of the target value, or -1 if not found
     */
    public static int search(int[] arr, int target) {
        // Your algorithm goes here!
        // Note... I know that the standard Java Arrays class has a method called
        // binarySearch.  If you use it for testing, but you need to implement the algorithm
        // to get the point!
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high)/2;
            if (arr[mid] != target) {
                if (target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int[] sort(int[] arr) {
        // Your algorithm goes here!
        int N = arr.length;
        if (N < 2) {
            return arr;
        }
        int midIndex = N / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[N - midIndex];
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = arr[i];
        }
        for (int i = midIndex; i < N; i++) {
            rightHalf[i - midIndex] = arr[i];
        }
        sort(leftHalf);
        sort(rightHalf);
        Merge(arr, leftHalf, rightHalf);
        return arr;
    }

    private static void Merge(int[] arr, int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};

        // Remember that a binary search requires a sorted array!
        // You can use one of your sorting methods here.
        sort(arr);

        ////////////////////////////////////////////////////////////
        // Do not change anything below this line!!
        ////////////////////////////////////////////////////////////
        boolean isSorted = true;
        for (int i=0; i<arr.length-1 && isSorted; i++) {
            if (arr[i] > arr[i+1]) {
                isSorted = false;
            }
        }
        printResult("Is sorted?", isSorted);
        printResult(82, search(arr, 82) == 44); // Find index in unsorted or sorted array
        printResult(49, search(arr, 49) == 24);
        printResult(-4, search(arr, -4) == -1);
    }

    public static void printResult(int target, boolean result) {
        System.out.println("Search for "+target+": "+((result) ? "CORRECT" : "INCORRECT"));
    }

    public static void printResult(String target, boolean result) {
        System.out.println(target+": "+((result) ? "CORRECT" : "INCORRECT"));
    }

}
