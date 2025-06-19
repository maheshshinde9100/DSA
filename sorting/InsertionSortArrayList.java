import java.util.*;

class Pair {
    int key;
    String value;

    Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
public class InsertionSortArrayList {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
            
    if (pairs == null || pairs.isEmpty()) {
        return result; 
    }

            result.add(deepCopy(pairs));

        for(int i=1;i<pairs.size();i++){
            Pair key = pairs.get(i);
            int j = i-1;
            while(j>=0 && pairs.get(j).key > key.key){
                pairs.set(j+1,pairs.get(j));
                j--; 
            }
            pairs.set(j+1,key);
            
            result.add(deepCopy(pairs));

        }
        return result;
    }

    List<Pair> deepCopy(List<Pair> list){
        List<Pair> copy = new ArrayList<>();
        for(Pair p:list){
            copy.add(new Pair(p.key,p.value));
        }
        return copy;
    }

public static void main(String[] args) {
    InsertionSortArrayList sorter = new InsertionSortArrayList();

    List<Pair> pairs1 = new ArrayList<>();
    pairs1.add(new Pair(5, "apple"));
    pairs1.add(new Pair(2, "banana"));
    pairs1.add(new Pair(9, "cherry"));

    System.out.println("Test Case 1:");
    List<List<Pair>> result1 = sorter.insertionSort(pairs1);
    printResult(result1);

    System.out.println("\nTest Case 2 (duplicate keys):");
    List<Pair> pairs2 = new ArrayList<>();
    pairs2.add(new Pair(3, "cat"));
    pairs2.add(new Pair(3, "bird"));
    pairs2.add(new Pair(2, "dog"));
    List<List<Pair>> result2 = sorter.insertionSort(pairs2);
    printResult(result2);

    System.out.println("\nTest Case 3 (empty list):");
    List<Pair> pairs3 = new ArrayList<>();
    List<List<Pair>> result3 = sorter.insertionSort(pairs3);
    printResult(result3);
}

private static void printResult(List<List<Pair>> result) {
    for (List<Pair> step : result) {
        System.out.print("[");
        for (int i = 0; i < step.size(); i++) {
            Pair p = step.get(i);
            System.out.print("(" + p.key + ", \"" + p.value + "\")");
            if (i < step.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
}
