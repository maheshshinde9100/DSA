package Patterns.MergeIntervals;

import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        //Q1
        int[][] intervals1 = {
                { 1, 2 },
                { 3, 6 },
                { 5, 8 },
                { 15, 18 }
        };
        //expected op: [[1,2],[3,8],[15,18]]
             System.out.println("Beforee : "+Arrays.deepToString(intervals1));
             System.out.println("After merged : "+Arrays.deepToString(merge(intervals1)));        
        // actual op: [[1,2],[3,8],[15,18]]   //correct

        //Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]

        //Q2
        int[][] intervals2 = new int[][]{
            {1,3},
            {5,7},
            {8,12}
        };
        int[] newInterval = new int[]{4,6};
        System.out.println("Beforee : "+Arrays.deepToString(intervals2));
        System.out.println("After merge with new interval : "+Arrays.deepToString(mergeWithNewInterval(intervals2, newInterval)));

        // Output: [[1,3], [4,7], [8,12]]
        // Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < current[1]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);
        return merged.toArray(new int[merged.size()][]);
    }

    //Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
    // Output: [[1,3], [4,7], [8,12]]
     public static int[][] mergeWithNewInterval(int[][] intervals,int[] newInterval) {
        if(intervals.length==0){
            if(newInterval.length!=0){
                return new int[][]{newInterval};
            }
            return new int[0][];
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        while(i<intervals.length && intervals[i][1]< newInterval[0]){
            merged.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0] < newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);

        while(i<intervals.length){
            merged.add(intervals[i]);
            i++;
        }

        return merged.toArray(new int[0][]);
     }
}
