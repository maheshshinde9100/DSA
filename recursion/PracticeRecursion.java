public class PracticeRecursion {
    static int count = 0;

    public static void main(String[] args) {
        int n = 5; // 1 2 3 4 5
                   // 5 4 3 2 1
        // System.out.println(printOneToN(1,n)); //done
        // System.out.println(printNToOne(n)); //done
        // System.out.println(printBoth(n)); //done

        // Power of a number (a^b)
        // Input: 2^5 → Output: 32
        int x = 2, y = 5;
       System.out.println(pow(x, y));
    }

    private static int printOneToN(int count, int n) {
        if (count == n) {
            return n;
        }
        System.out.print(count + " ");
        return printOneToN(count + 1, n);
    }

    private static int printNToOne(int n) {
        if (n <= 1) {
            return n;
        }
        System.out.print(n + " ");
        return printNToOne(n - 1);
    }

    private static int printBoth(int n) {
        if (count == n) {
            return 0;
        }
        System.out.print(n - count + " ");
        count++;
        System.out.print(count + "\n");

        return printBoth(n);
    }

    private static int pow(int x, int n) { //x^y
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * pow(x, n - 1);
        } else {
            return 1 / pow(x, -n);
        }
    }
}
