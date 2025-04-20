import java.util.Scanner;

public class CyclicSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array (should contain numbers from 1 to n)");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements (values must be from 1 to " + n + "):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 1 || arr[i] > n) {
                System.out.println("Invalid input! Value should be between 1 and " + n);
                return; // exit the program
            }
        }

        sort(arr);
        display(arr);
    }

    public static void sort(int[] arr){
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

    public static void display(int[] arr){
        System.out.println("The array after cyclic sort :>");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
