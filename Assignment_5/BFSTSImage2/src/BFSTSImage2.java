import java.util.*;

public class BFSTSImage2 {
    static class Graph {
        int vertices;
        List<Integer> adjVertices[];

        public Graph(int vertices) {
            this.vertices = vertices;
            adjVertices = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++)
                adjVertices[i] = new ArrayList<Integer>();
        }

        public void addPath( char u, char v) {
            int num1=u;
            int num2=v;
            adjVertices[num1].add(num2);
        }

        public void BFStopologicalSort() {
            int inDegree[] = new int[vertices];

            for (int i = 0; i < vertices; i++) {
                ArrayList<Integer> tmp = (ArrayList<Integer>) adjVertices[i];
                for (int vertex : tmp) {
                    inDegree[vertex]++;
                }
            }
            Queue<Integer> queue= new LinkedList<Integer>();
            for (int i = 0; i < vertices; i++) {
                if (inDegree[i] == 0)
                    queue.add(i);
            }
            int countVisited = 0;

            Vector<Integer> BFSTS = new Vector<Integer>();
            while (!queue.isEmpty()) {

                int u = queue.poll();
                BFSTS.add(u);

                for (int vertex : adjVertices[u]) {
                    if (inDegree[vertex]-- == 0)
                        queue.add(vertex);
                }
                countVisited++;
            }

            if (countVisited != vertices) {
                System.out.println("Loop detected.");
                return;
            }

            for (int i : BFSTS) {
                System.out.print((i) + " ");
            }
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(135);
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
        System.out.println("BFS Topological sort: ");
        graph.BFStopologicalSort();
    }

}