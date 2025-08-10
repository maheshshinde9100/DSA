package dynammic_programming;
/*
Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
 */
public class KnapSack01 {
    static int knapsack(int W, int val[], int wt[]) {
        // W = capacity of knapsack
        // wt[] = weight array
        // val[] = profit array

        int[][] t = new int[wt.length+1][W+1];

        for(int i=0;i<wt.length+1;i++){
            for(int j=0;j<W+1;j++){

                if(i==0 || j==0){
                    t[i][j] = 0;
                }else{

                    if(wt[i-1] <= j){
                        t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]],
                                t[i-1][j]
                        );
                    }else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }
        }
        return t[wt.length][W];

    }

    public static void main(String[] args) {
       int  W = 4;
       int[] val = new int[]{1, 2, 3};
       int[] wt = new int[]{4, 5, 1};
        System.out.println(knapsack(W,val,wt));
    }
}
