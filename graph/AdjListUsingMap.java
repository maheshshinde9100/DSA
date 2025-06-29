package graph;

import java.util.*;
public class AdjListUsingMap {
    public Map<Integer, List<Integer>> adjList = new HashMap<>();

    AdjListUsingMap(List<Integer> list){
        for(int i=0;i<list.size();i++){
            adjList.put(list.get(i), new ArrayList<>());
        }
    }

    public void addEdge(int src,int dest){
        //bidirectional
        if(isPresent(src) && isPresent(dest)){
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }else{
            System.out.println("src or dest is invalid..!");
        }
    }

    public boolean isPresent(int element){
        for(Integer key: adjList.keySet()){
            if(key == element){
                return true;
            }
        }
        return false;
    }

    public void display(){
        for(Integer key: adjList.keySet()){
            System.out.print("\n"+key+" ->\t");
            List<Integer> temp = adjList.get(key);
            for(Integer val : temp){
                System.out.print(val+" ->\t");
            }
        }
    }

    
    public void BFS(int start){
        if(!isPresent(start)){
            System.err.println("\ninvalid starting vertex :> "+start);
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited  = new HashSet<>();
        q.offer(start);
        visited.add(start);
        System.out.println("\n\nGraph BFS Traversal starting from :> "+start+"\n");

        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current+"\t");

            // List<Integer> list = adjList.get(current);

            for(int neighbour: adjList.getOrDefault(current, new ArrayList<>())){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    q.offer(neighbour);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int start){
        if(!isPresent(start)){
            System.err.println("\ninvalid starting vertex :> "+start);
            return;
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(start);
        visited.add(start);
        
        System.out.println("\n\nGraph DFS Traversal starting from :> "+start+"\n");

        while(!stack.isEmpty()){
            int current = stack.pop();
            System.out.print(current+"\t");

             for(int neighbour: adjList.getOrDefault(current, new ArrayList<>())){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    stack.push(neighbour);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

//      1------------2----------5
//      |            |          |
//      3------------4----------6

//      BFS :> 1 2 3 4

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        AdjListUsingMap obj = new AdjListUsingMap(list);
        obj.addEdge(1, 2);
        obj.addEdge(1, 3);
        obj.addEdge(3, 4);
        obj.addEdge(4, 6);
        obj.addEdge(5,6);
        obj.addEdge(2,5);
        obj.addEdge(2,4);


        obj.display();

        int start = 1;     
        obj.BFS(start);    
        //correct output and logic for BFS Traversal

        obj.DFS(1);
    }
}
