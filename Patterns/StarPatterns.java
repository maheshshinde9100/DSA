package Patterns;

public class StarPatterns {
    public static void main(String[] args) {
////            1.  *****
////                *****
////                *****
////                *****
////                *****
//        System.out.println("First Pattern :> ");
//        firstPattern();
////            2.  *
////                **
////                ***
////                ****
////                *****
//        System.out.println("Second Pattern :> ");
//        secondPattern();
////            3.  *****
////                ****
////                ***
////                **
////                *
//        System.out.println("Third Pattern :> ");
//        thirdPattern();
////    4.  1
////        1 2
////        1 2 3
////        1 2 3 4
////        1 2 3 4 5
//        System.out.println("Fourth Pattern :> ");
//        fourthPattern();
////            5.  *
////                **
////                ***
////                ****
////                *****
////                ****
////                ***
////                **
////                *
//        System.out.println("Fifth Pattern :> ");
//        fifthPattern();

//        6.          *
//                   **
//                  ***
//                 ****
//                *****
//        System.out.println("Sixth Pattern :> ");
//        sixthPattern();
//           7.   *****
//                 ****
//                  ***
//                   **
//                    *
//        System.out.println("Seventh Pattern :> ");
//        seventhPattern();

//        8.      *
//               ***
//              *****
//             *******
//            *********
//        System.out.println("Eighth Pattern :> ");
//        eighthPattern();

//        9.  *********
//             *******
//              *****
//               ***
//                *
//        System.out.println("ningth Pattern :> ");
//        ninethPattern();
//        10.      *
//                * *
//               * * *
//              * * * *
//             * * * * *
//        System.out.println("tenth Pattern :> ");
//        tenthPattern();
//       11.  * * * * *
//             * * * *
//              * * *
//               * *
//                *
        System.out.println("11th Pattern :> ");
        eleventhPattern();
    }

    static void firstPattern() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void secondPattern() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void thirdPattern() {
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void fourthPattern() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    static void fifthPattern() {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 4; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void sixthPattern() {
        for (int i = 0; i < 5; i++) {
            for (int j = 5 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void seventhPattern() {
        for (int i = 5; i > 0; i--) {
            for (int j = 5 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void eighthPattern() {
        int white = 4;
        for (int i = 0; i < 9; i = i + 2) {
            for (int w = white; w > 0; w--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int w = white; w > 0; w--) {
                System.out.print(" ");
            }
            white--;
            System.out.println();
        }
    }
    static void ninethPattern() {
        int white = 0;
        for (int i = 9; i > 0; i = i - 2) {
            white++;
            for (int w = 0; w < white; w++) {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            for (int w = 0; w < white; w++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void tenthPattern() {
        int white = 3;
        for (int i = 0; i < 5; i++) {
            for (int w = white; w > 0; w--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" * ");
            }
            for (int w = white; w > 0; w--) {
                System.out.print(" ");
            }
            white--;

            System.out.println();
        }
    }
    static void eleventhPattern() {
        int white = 0;
        for (int i = 5; i > 0; i--) {
            for (int w = 0; w < white; w++) {
                System.out.print(" ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            for (int w = 0; w < white; w++) {
                System.out.print(" ");
            }
            white++;
            System.out.println();
        }
    }
}
