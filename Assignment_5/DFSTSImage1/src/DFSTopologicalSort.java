import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class DFSTopologicalSort {

    static class Graph {
        int vertices;
        LinkedList<Integer>[] adjVertices;

        Graph(int vertices) {
            this.vertices = vertices;
            adjVertices = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjVertices[i] = new LinkedList<>();
            }
        }
        public void addPath(int a, int b) {
            adjVertices[a].addFirst(b);
        }
        public void topologicalSort() {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    recurTopologicalSort(i, visited, stack);
                }
            }
            System.out.println("Topological Sort(DFS): ");
            int size = stack.size();
            for (int i = 0; i <size ; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        public void recurTopologicalSort(int initial, boolean[] visited, Stack<Integer> stack) {
            visited[initial] = true;
            for(int i:adjVertices[initial]){
                if(!visited[i]){
                    recurTopologicalSort(i,visited,stack);
                }
                else{System.out.println("Loop detected at: "+i);}
            }
            stack.push(initial);
        }
    }

    public static void main(String[] args) {
        int vertices = 9   ;
        Graph graph = new Graph(vertices);

        graph.addPath(1, 2);
        graph.addPath(1, 5);
        graph.addPath(1, 6);
        graph.addPath(2, 3);
        graph.addPath(2, 5);
        graph.addPath(2, 7);
        graph.addPath(3, 4);
        graph.addPath(4, 5);
        graph.addPath(5, 7);
        graph.addPath(5, 8);
        graph.addPath(6, 5);
        graph.addPath(6, 8);
        graph.addPath(7, 8);
        graph.addPath(7, 4);



        graph.topologicalSort();
    }
}