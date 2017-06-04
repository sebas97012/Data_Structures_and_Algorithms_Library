package org.tec.datastructures;

public class Graph {
    private int row;
    private int col;
    private int nodesIn;
    private int INF = 99999999;     //
    private int[][] matrix;
    private GraphNode[] arrayReferencia;    //

    public Graph(int nodes){
        matrix = new int[nodes][nodes];
        arrayReferencia = new GraphNode[nodes];
        this.col = nodes;
        this.row = nodes;
        this.nodesIn = 0;
    }

    public void addNode(Comparable nodeData){
        GraphNode newNode = new GraphNode(nodeData);

        if(nodesIn == row){
            System.out.println("Error");
        }
        else{
            arrayReferencia[nodesIn] = newNode;
            matrix[nodesIn][nodesIn] = 0;
            nodesIn += 1;
        }
    }

    //No sé cómo traducir el método////////////////////
    public void adherirConexionDirigda(Comparable ele1, Comparable ele2, int weigth){
        int x = 0;
        int y = 0;
        int Node1Pos = x;

        while(arrayReferencia[x].getData().compareTo(ele1) != 0){
            x += 1;
        }

        while(arrayReferencia[y].getData().compareTo(ele2)!=0){
            y+=1;
        }

        int Node2Pos = y;
        matrix[Node1Pos][Node2Pos] = weigth;
    }

    //No sé cómo traducir el método////////////////////
    public void adherirConexionNoDirigida(Comparable ele1, Comparable ele2, int weigth){
        int x = 0;
        int y = 0;
        int Node1Pos = x;

        while(arrayReferencia[x].getData().compareTo(ele1)!=0){
            x += 1;
        }

        while(arrayReferencia[y].getData().compareTo(ele2)!=0){
            y += 1;
        }

        int Node2Pos = y;
        matrix[Node1Pos][Node2Pos] = weigth;
        matrix[Node2Pos][Node1Pos] = weigth;
    }

    //No sé cómo traducir el método//////////////////////
    public void recorrerAnchura(Comparable firstNodeData){
        boolean[] visited = new boolean[row];
        Queue queueWidth = new Queue();
        int x = 0;

        while(arrayReferencia[x].getData().compareTo(firstNodeData) != 0){
            x+=1;
        }

        visited[x] =true;
        queueWidth.enqueue(arrayReferencia[x].getData());

        while(queueWidth.getTope() != null){      //Falta el método///////////////
            firstNodeData = (int) queueWidth.pop().getT();   //Falta el método///////////////
            x = 0;
            int y = 0;

            while(arrayReferencia[x].getData().compareTo(firstNodeData) != 0){
                x+=1;
            }

            //¿Quitar prints?
            System.out.println(firstNodeData + " ");

            while(y <= col-1){
                if(matrix[x][y] != 0){
                    if(!visited[y]){
                        queueWidth.enqueue(arrayReferencia[y].getData());
                        visited[y] = true;
                        y++;
                    }
                    else{
                        y++;
                    }
                }
                else{
                    y++;
                }
            }
        }

    }

    //No sé cómo traducir el método//////////////////////
    //No estoy seguro de si "pilaProfundidad" se puede pasar a "stackHeigth". No sé a qué se refiere "profundidad"
    public void recorrerProfundidad(Comparable firsNodeData){
        boolean[] visited = new boolean[row];
        Stack stackHeigth = new Stack();
        int x = 0;

        while(arrayReferencia[x].getData().compareTo(firsNodeData)!=0){
            x+=1;
        }

        visited[x] =true;
        stackHeigth.push(arrayReferencia[x].getData());
        while(stackHeigth.getTope()!=null){
            firsNodeData = (int) stackHeigth.pop().getT();
            x = 0;
            int y = 0;

            while(arrayReferencia[x].getData().compareTo(firsNodeData)!=0){
                x+=1;
            }

            //¿Quitar print?//////////
            System.out.println(firsNodeData + " ");

            while(y <= col-1){
                if(matrix[x][y] != 0){
                    if(!visited[y]){
                        stackHeigth.push(arrayReferencia[y].getData());
                        visited[y] = true;
                        y++;
                    }
                    else{
                        y++;
                    }
                }
                else{
                    y++;
                }
            }
        }

    }

    public int[] DijAlg(Comparable firstNodeData){
        int shortPaths[] = new int[row];
        Boolean[] visited = new Boolean[row];
        int x2 = 0;

        for(int x = 0; x < row; x++){
            shortPaths[x] = Integer.MAX_VALUE;
            visited[x] = false;
        }

        while(arrayReferencia[x2].getData().compareTo(firstNodeData) != 0){
            x2 += 1;
        }

        shortPaths[x2] = 0;

        for(int cont = 0; cont < row-1; cont++){
            int dis = minDistance(shortPaths,visited);
            visited[dis] = true;

            for(int cont2 = 0; cont2 < row; cont2++){
                if (!visited[cont2] && matrix[dis][cont2] != 0 && shortPaths[dis] != Integer.MAX_VALUE && shortPaths[dis] + matrix[dis][cont2] < shortPaths[cont2]){
                    shortPaths[cont2] = shortPaths[dis] + [dis][cont2];     //////////////////////////
                }
            }
        }
        return shortPaths;
    }
    public int[][] FloydAlg(int[][] ConecctionMatrix){
        int shortPaths[][] = new int[row][row];
        int x;
        int y;
        int z;

        for(int cont = 0; cont < row; cont++){
            for(int cont2 = 0; cont2 < row; cont2++){
                if(ConecctionMatrix[cont][cont2] == 0){
                    ConecctionMatrix[cont][cont2] = INF;
                }
            }
        }

        for(x = 0; x < row; x++){
            for(y = 0;y < row; y++){
                shortPaths[x][y] = ConecctionMatrix[x][y];
            }
        }

        for(z = 0; z < row; z++){
            for(x = 0; x < row; x++){
                for(y = 0;y < row; y++){
                    if(shortPaths[x][z] + shortPaths[z][y] < shortPaths[x][y]){
                        if(shortPaths[x][z] + shortPaths[z][y] != 0){
                            shortPaths[x][y] = shortPaths[x][z] + shortPaths[z][y];
                        }
                    }
                }
            }
        }
        return shortPaths;
    }

    public int[][] WarshallAlg(int[][] ConecctionMatrix){
        int shortPaths[][] = new int[row][row];
        int x;
        int y;
        int z;

        for(int cont = 0; cont < row; cont++){
            for(int cont2 = 0; cont2 < row; cont2++){
                if(ConecctionMatrix[cont][cont2] == 0){
                    if(cont == cont2){
                        /////////////////////////////////////////////////////////7
                    }
                    else{
                        ConecctionMatrix[cont][cont2] = INF;
                    }
                }
            }
        }

        for(x = 0; x < row; x++){
            for(y = 0; y < row; y++){
                shortPaths[x][y] = ConecctionMatrix[x][y];
            }
        }

        for(z = 0; z < row; z++){
            for(x = 0; x < row; x++){
                for(y = 0; y < row; y++){
                    if(shortPaths[x][z] + shortPaths[z][y] <= shortPaths[x][y] && shortPaths[x][z] != INF && shortPaths[z][y] != INF){
                        if(shortPaths[x][z] + shortPaths[z][y] != 0){
                            shortPaths[x][y] = 1;
                        }
                    }
                }
            }
        }
        return shortPaths;
    }

    public int[] PrimAlg(int[][] ConecctionMatrix){
        int[] MST = new int[row];
        int[] minValues = new int[row];
        Boolean[] visited = new Boolean[row];

        for(int cont = 0; cont < row; cont++){
            minValues[cont] = INF;
            visited[cont] = false;
        }

        minValues[0] = 0;
        MST[0] = 0;

        for(int cont2 = 0; cont2 < row-1; cont2++){
            int minimum = minDistance(minValues, visited);
            visited[minimum] = true;

            for(int cont3 = 0; cont3 < row; cont3++){
                if(ConecctionMatrix[minimum][cont3] != 0 && !visited[cont3] && matrix[minimum][cont3] < minValues[cont3]){
                    MST[cont3] = ConecctionMatrix[minimum][cont3];
                    minValues[cont3] = ConecctionMatrix[minimum][cont3];
                }
            }
        }
        return MST;

    }

    public int minDistance(int shortPaths[], Boolean visited[]){
        int minimum = Integer.MAX_VALUE;
        int minIndex =- 1;

        for (int cont = 0; cont < row; cont++){
            if (!visited[cont] && shortPaths[cont] < minimum) {
                minimum = shortPaths[cont];
                minIndex = cont;
            }
        }
        return minIndex;
    }
}
