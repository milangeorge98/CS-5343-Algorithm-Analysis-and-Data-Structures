import java.util.LinkedList;
import java.util.Stack;

public class DFSTSImage2 {
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
        public void addPath( char u, char v) {
            int num1=u;
            int num2=v;
            adjVertices[num1].add(num2);
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
        int vertices = 14   ;
        Graph graph = new Graph(123);
        graph.addPath('m', 'r');
        graph.addPath('m', 'q');
        graph.addPath('m' , 'x' );
        graph.addPath('n' , 'q' );
        graph.addPath('n' , 'u' );
        graph.addPath('n' , 'o' );
        graph.addPath('o' , 'r' );
        graph.addPath('o' , 's' );
        graph.addPath('o' , 'v' );
        graph.addPath('p' , 'o' );
        graph.addPath('p' , 's' );
        graph.addPath('p' , 'z' );
        graph.addPath('q' , 't' );
        graph.addPath('r' , 'u' );
        graph.addPath('r' , 'y' );
        graph.addPath('s' , 'r' );
        graph.addPath('u' , 't' );
        graph.addPath('v' , 'x' );
        graph.addPath('v' , 'w' );
        graph.addPath('w' , 'z' );
        graph.addPath('y' , 'v' );

        graph.topologicalSort();
    }
}
