import java.util.Scanner;

public class AllSortingAlgorithms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] original = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextInt();
        }

        System.out.println("\nChoose Sorting Algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Cyclic Sort (only for 1 to n values)");
        System.out.println("5. Quick Sort");
        int choice = sc.nextInt();

        // Clone the original array to preserve it for other sorts
        int[] arr = original.clone();
        switch (choice) {
            case 1:
                bubbleSort(arr);
                break;
            case 2:
                selectionSort(arr);
                break;
            case 3:
                insertionSort(arr);
                break;
            case 4:
                if (validateForCyclicSort(arr)) {
                    cyclicSort(arr);
                } else {
                    System.out.println("Cyclic sort requires elements from 1 to n with no duplicates.");
                    return;
                }
                break;
            case 5:
                quickSort(arr, 0, arr.length - 1);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Sorted array:");
        display(arr);
    }

    // 1. Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // 2. Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    // 3. Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 4. Cyclic Sort (only works for numbers from 1 to n)
    public static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    public static boolean validateForCyclicSort(int[] arr) {
        int n = arr.length;
        boolean[] seen = new boolean[n + 1];
        for (int val : arr) {
            if (val < 1 || val > n || seen[val]) return false;
            seen[val] = true;
        }
        return true;
    }

    // 5. Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIdx = partition(arr, low, high);
            quickSort(arr, low, pIdx - 1);
            quickSort(arr, pIdx + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Utility functions
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void display(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
