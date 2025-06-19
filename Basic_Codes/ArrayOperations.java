import java.util.Arrays;

public class ArrayOperations {

    // Insert element at the end of the array
    public static int[] insertAtEnd(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = element;
        return newArr;
    }

    // Insert element at a specific position
    public static int[] insertAtPosition(int[] arr, int element, int position) {
        if (position < 0 || position > arr.length) {
            System.out.println("Invalid position");
            return arr;
        }
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, position);
        newArr[position] = element;
        System.arraycopy(arr, position, newArr, position + 1, arr.length - position);
        return newArr;
    }

    // Delete element by index
    public static int[] deleteByIndex(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid index");
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
    }

    // Find an element in the array
    public static int findElement(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;  // Element found, return index
            }
        }
        return -1;  // Element not found
    }

    // Sort an array
    public static void sortArray(int[] arr) {
        Arrays.sort(arr);  // Sort the array
    }

    // Reverse an array
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example to test the array operations
        int[] arr = {1, 2, 3, 4, 5};

        // Insert at the end
        arr = insertAtEnd(arr, 6);
        System.out.println("Array after insert at end: " + Arrays.toString(arr));

        // Insert at position
        arr = insertAtPosition(arr, 7, 3);
        System.out.println("Array after insert at position 3: " + Arrays.toString(arr));

        // Delete by index
        arr = deleteByIndex(arr, 2);
        System.out.println("Array after delete index 2: " + Arrays.toString(arr));

        // Find element
        int index = findElement(arr, 4);
        System.out.println("Element 4 found at index: " + index);

        // Sort array
        sortArray(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Reverse array
        reverseArray(arr);
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}
