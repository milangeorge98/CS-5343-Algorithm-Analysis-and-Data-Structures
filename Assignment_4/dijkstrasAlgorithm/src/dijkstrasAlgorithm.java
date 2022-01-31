
class Dijkstra{
 
    private static void dijkstra(int[][] adjacencyMatrix,
                                 int initialPoint)
    {
        int nVertices = adjacencyMatrix[0].length;
        int[] distances = new int[nVertices];
        boolean[] visited = new boolean[nVertices];
        for (int j = 0; j < nVertices; j++)
        {
            distances[j] = Integer.MAX_VALUE;
            visited[j] = false;
        }
        distances[initialPoint] = 0;
        int[] SPTArray = new int[nVertices];
        SPTArray[initialPoint] = -1;
        for (int i = 1; i < nVertices; i++)
        {
            int minVertex = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int j = 0;j < nVertices;j++)
            {
                if (!visited[j] && distances[j] < minDistance)
                {
                    minVertex = j;
                    minDistance = distances[j];
                }
            }
            visited[minVertex] = true;

            for (int k = 0; k < nVertices; k++)
            {
                int weight = adjacencyMatrix[minVertex][k];
                if (weight > 0 && ((minDistance + weight) < distances[k]))
                {
                    SPTArray[k] = minVertex; distances[k] = minDistance + weight;
                }
            }
        }
        printResult(initialPoint, distances, SPTArray);
    }

    private static void printResult(int initialPoint,
                                      int[] distances,
                                      int[] SPTArray)
    {
        int nVertices = distances.length;
        System.out.print("After Dijkstra's Algorithm\n");
        System.out.print("Vertex from source\t Weights\tPath");

        for (int i = 0; i < nVertices;i++)
        {
            if (i != initialPoint)
            {
                System.out.print("\n" + initialPoint + ",");
                System.out.print(i + " \t\t\t\t ");
                System.out.print(distances[i] + "\t\t\t");
                printPath(i, SPTArray);
            }
        }

    }

    private static void printVerticesBefore(int [][]adjacencyMatrix){
        int vertices = adjacencyMatrix.length;
        System.out.println("Vertices pair");
        int countEdges=0;
        for(int i=0; i<vertices;i++){
            for(int j=0; j<vertices;j++){
                if(adjacencyMatrix[i][j]!=0){
                    System.out.println(i+" ,"+j );
                    countEdges +=1;

                }}}System.out.println("NUMBER OF EDGES FOR THE UNDIRECTED GRAPH: "+countEdges/2);
    }

    private static void printPath(int currentVertex,
                                  int[] SPTArray)
    {
        if (currentVertex == -1)
        {
            return;
        }
        printPath(SPTArray[currentVertex], SPTArray);
        System.out.print(currentVertex + " ");
    }

    public static void main(String[] args)
    {
        int[][] adjacencyMatrix =
                {   { 0, 6, 0, 0, 0, 0, 0, 8, 0, 9,15 },
                    { 6, 0, 12, 0, 0, 0, 0, 19, 0 ,10,25},
                    { 0, 12, 0, 5, 0, 4, 0, 0, 2 ,0,0},
                    { 0, 0, 5, 0, 17, 14, 0, 7, 0 ,0,21},
                    { 0, 0, 0, 17, 0, 10, 0, 0, 0 ,0,0},
                    { 0, 0, 4, 0, 10, 0, 2, 0, 0 ,0,0},
                    { 0, 0, 0, 14, 0, 2, 0, 1, 6 ,0,0},
                    { 8, 19, 0, 0, 0, 0, 1, 0, 7 ,8,0},
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0,0,0 },
                    { 9, 10, 0, 7, 0, 0, 0, 8, 0, 0 ,0},
                    { 15, 25, 10, 0, 7, 0, 0, 0, 8, 0, 0 },
                    };
        printVerticesBefore(adjacencyMatrix);
        dijkstra(adjacencyMatrix, 0);
    }
}

