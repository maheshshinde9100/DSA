package Patterns;

public class StarPatterns {
    public static void main(String[] args) {
//            1.  *****
//                *****
//                *****
//                *****
//                *****
        System.out.println("First Pattern :> ");
        firstPattern();
//            2.  *
//                **
//                ***
//                ****
//                *****
        System.out.println("Second Pattern :> ");
        secondPattern();
//            3.  *****
//                ****
//                ***
//                **
//                *
        System.out.println("Third Pattern :> ");
        thirdPattern();
//    4.  1
//        1 2
//        1 2 3
//        1 2 3 4
//        1 2 3 4 5
        System.out.println("Fourth Pattern :> ");
        fourthPattern();

        //remaining from 5 to 20
    }
    static void firstPattern(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void secondPattern(){
        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void thirdPattern(){
        for(int i=0;i<5;i++){
            for(int j=5;j>i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void fourthPattern(){
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
