package bibliotecagrafos;

public class BibliotecaGrafos {

    public static void main(String[] args) {
        
        //GRAFO 1 n, d donde d = valor esperado de nodos ady por cada nodo
        Grafo g1[] = new Grafo[3];
        g1[0] = Grafo.genBarabasiAlbert(30, 12 , false, false);
        g1[1] = Grafo.genBarabasiAlbert(100, 12 , false, false);
        g1[2] = Grafo.genBarabasiAlbert(500, 15 , false, false);
        
        g1[0].exportGraph("genBarabasiAlbert30");        
        g1[1].exportGraph("genBarabasiAlbert100");        
        g1[2].exportGraph("genBarabasiAlbert500");
        
        g1[0].DFS_TREE_R(0).exportGraph("genBarabasiAlbert30_DFS_TREE_R");
        g1[0].DFS_TREE_I(0).exportGraph("genBarabasiAlbert30_DFS_TREE_I");
        g1[0].BFS(0).exportGraph("genBarabasiAlbert30_BFS");
        g1[1].DFS_TREE_R(0).exportGraph("genBarabasiAlbert100_DFS_TREE_R");
        g1[1].DFS_TREE_I(0).exportGraph("genBarabasiAlbert100_DFS_TREE_I");
        g1[1].BFS(0).exportGraph("genBarabasiAlbert100_BFS");
        g1[2].DFS_TREE_R(0).exportGraph("genBarabasiAlbert500_DFS_TREE_R");
        g1[2].DFS_TREE_I(0).exportGraph("genBarabasiAlbert500_DFS_TREE_I");;
        g1[2].BFS(0).exportGraph("genBarabasiAlbert500_BFS");
         
        
        
        //Grafos  exactamente el numero de aristas
        Grafo g2[] = new Grafo[3];
        g2[0] = Grafo.genErdosRenyi(30, 50, false, false);
        g2[1] = Grafo.genErdosRenyi(100, 250, false, false);
        g2[2] = Grafo.genErdosRenyi(500, 800, false, false);
        
        g2[0].exportGraph("genErdosRenyi30");        
        g2[1].exportGraph("genErdosRenyi100");        
        g2[2].exportGraph("genErdosRenyi500");
        
        g2[0].DFS_TREE_R(0).exportGraph("genErdosRenyi30_DFS_TREE_R");
        g2[0].DFS_TREE_I(0).exportGraph("genErdosRenyi30_DFS_TREE_I");;
        g2[0].BFS(0).exportGraph("genErdosRenyi30_BFS");
        g2[1].DFS_TREE_R(0).exportGraph("genErdosRenyi100_DFS_TREE_R");
        g2[1].DFS_TREE_I(0).exportGraph("genErdosRenyi100_DFS_TREE_I");
        g2[1].BFS(0).exportGraph("genErdosRenyi100_BFS");
        g2[2].DFS_TREE_R(0).exportGraph("genErdosRenyi500_DFS_TREE_R");
        g2[2].DFS_TREE_I(0).exportGraph("genErdosRenyi500_DFS_TREE_I");
        g2[2].BFS(0).exportGraph("genErdosRenyi500_BFS");
        
        
        //Grafos  exactamente el numero de aristas rectangulo 
        Grafo g3[] = new Grafo[3];
        g3[0] = Grafo.genGeografico(30,  0.2, false, false);
        g3[1] = Grafo.genGeografico(100, 0.2, false, false);
        g3[2] = Grafo.genGeografico(500, 0.1, false, false);
        
        g3[0].exportGraph("genGeografico30");        
        g3[1].exportGraph("genGeografico100");
        g3[2].exportGraph("genGeografico500");        
        
        g3[0].DFS_TREE_R(0).exportGraph("genGeografico30_DFS_TREE_R");        
        g3[0].DFS_TREE_I(0).exportGraph("genGeografico30_DFS_TREE_I");        
        g3[0].BFS(0).exportGraph("genGeografico30_BFS");        
        g3[1].DFS_TREE_R(0).exportGraph("genGeografico100_DFS_TREE_R");        
        g3[1].DFS_TREE_I(0).exportGraph("genGeografico100_DFS_TREE_I");        
        g3[1].BFS(0).exportGraph("genGeografico100_BFS");        
        g3[2].DFS_TREE_R(0).exportGraph("genGeografico500_DFS_TREE_R");        
        g3[2].DFS_TREE_I(0).exportGraph("genGeografico500_DFS_TREE_I");        
        g3[2].BFS(0).exportGraph("genGeografico500_BFS");        
        
        
        //Grafos  probabilidad de que dos nodos esten conectados
        Grafo g4[] = new Grafo[3];
        g4[0] = Grafo.genGilbert(30,  0.3, false, false);
        g4[1] = Grafo.genGilbert(100, 0.3, false, false);
        g4[2] = Grafo.genGilbert(500, 0.09, false, false);
        
        g4[0].exportGraph("genGilbert30");        
        g4[1].exportGraph("genGilbert100");        
        g4[2].exportGraph("genGilbert500");
        
        
        g4[0].DFS_TREE_R(0).exportGraph("genGilbert30_DFS_TREE_R");
        g4[0].DFS_TREE_I(0).exportGraph("genGilbert30_DFS_TREE_I");
        g4[0].BFS(0).exportGraph("genGilbert30_BFS");
        g4[1].DFS_TREE_R(0).exportGraph("genGilbert100_DFS_TREE_R");
        g4[1].DFS_TREE_I(0).exportGraph("genGilbert100_DFS_TREE_I");
        g4[1].BFS(0).exportGraph("genGilbert100_BFS");
        g4[2].DFS_TREE_R(0).exportGraph("genGilbert500_DFS_TREE_R");
        g4[2].DFS_TREE_I(0).exportGraph("genGilbert500_DFS_TREE_I");
        g4[2].BFS(0).exportGraph("genGilbert500_BFS");
        
   
        
    }
    
}
