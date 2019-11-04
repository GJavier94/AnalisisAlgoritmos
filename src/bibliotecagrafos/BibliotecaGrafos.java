package bibliotecagrafos;

public class BibliotecaGrafos {

    public static void main(String[] args) {
        
//-------------------------------Proyecto 1----------------------------------------------------------
        /*
        Grafo g1[] = new Grafo[3];
        g1[0] = Grafo.genBarabasiAlbert(30, 5 , false, false);
        g1[1] = Grafo.genBarabasiAlbert(100,4 , false, false);
        g1[2] = Grafo.genBarabasiAlbert(500,3 , false, false);
        
        g1[0].exportGraph("genBarabasiAlbert30");        
        g1[1].exportGraph("genBarabasiAlbert100");        
        g1[2].exportGraph("genBarabasiAlbert500");                
                
        Grafo g2[] = new Grafo[3];
        g2[0] = Grafo.genErdosRenyi(30, 100 , false, false);
        g2[1] = Grafo.genErdosRenyi(100, 350, false, false);
        g2[2] = Grafo.genErdosRenyi(500, 700, false, false);
        
        g2[0].exportGraph("genErdosRenyi30");        
        g2[1].exportGraph("genErdosRenyi100");        
        g2[2].exportGraph("genErdosRenyi500");
                        
        Grafo g3[] = new Grafo[3];
        g3[0] = Grafo.genGeografico(30,  0.5, false, false);
        g3[1] = Grafo.genGeografico(100, 0.1, false, false);
        g3[2] = Grafo.genGeografico(500, 0.08, false, false);
        
        g3[0].exportGraph("genGeografico30");        
        g3[1].exportGraph("genGeografico100");
        g3[2].exportGraph("genGeografico500");        
               
        Grafo g4[] = new Grafo[3];
        g4[0] = Grafo.genGilbert(30,  0.6, false, false);
        g4[1] = Grafo.genGilbert(100, 0.4, false, false);
        g4[2] = Grafo.genGilbert(500, 0.02, false, false);
        
        g4[0].exportGraph("genGilbert30");        
        g4[1].exportGraph("genGilbert100");        
        g4[2].exportGraph("genGilbert500");
        
        */
//-------------------------------Proyecto 2----------------------------------------------------------        
        /*
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
        
        Grafo g2[] = new Grafo[3];
        g2[0] = Grafo.genErdosRenyi(30, 100, false, false);
        g2[1] = Grafo.genErdosRenyi(100, 250, false, false);
        g2[2] = Grafo.genErdosRenyi(500, 750, false, false);
        
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
        
        Grafo g3[] = new Grafo[3];
        g3[0] = Grafo.genGeografico(30,  0.4, false, false);
        g3[1] = Grafo.genGeografico(100, 0.3, false, false);
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
        
        Grafo g4[] = new Grafo[3];
        g4[0] = Grafo.genGilbert(30,  0.5, false, false);
        g4[1] = Grafo.genGilbert(100, 0.3, false, false);
        g4[2] = Grafo.genGilbert(500, 0.005, false, false);
        
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
        
//-------------------------------Proyecto 3----------------------------------------------------------
        /*           
        Grafo g1[] = new Grafo[3];
        g1[0] = Grafo.genBarabasiAlbert(30, 12 , false, false);
        g1[1] = Grafo.genBarabasiAlbert(100, 12 , false, false);
        g1[2] = Grafo.genBarabasiAlbert(500, 15 , false, false);
        
        for(int i = 0; i < g1.length; i++) g1[i].RandomEdgeValues(1, 100);
        
        
        g1[0].exportGraphWeighted("genBarabasiAlbert30");        
        g1[1].exportGraphWeighted("genBarabasiAlbert100");        
        g1[2].exportGraphWeighted("genBarabasiAlbert500");
        
        Grafo g;
        g = g1[0].Dijkstra(g1[0].nodes.get(0));
        g.exportGraphUnWeighted("genBarabasiAlbert30_Dijkstra");
        
        g = g1[1].Dijkstra(g1[1].nodes.get(0));
        g.exportGraphUnWeighted("genBarabasiAlbert100_Dijkstra");
        
        g = g1[2].Dijkstra(g1[2].nodes.get(0));
        g.exportGraphUnWeighted("genBarabasiAlbert500_Dijkstra");
        
        Grafo g2[] = new Grafo[3];
        g2[0] = Grafo.genErdosRenyi(30, 50, false, false);
        g2[1] = Grafo.genErdosRenyi(100, 250, false, false);
        g2[2] = Grafo.genErdosRenyi(500, 800, false, false);
        
        for(int i = 0; i < g2.length; i++) g2[i].RandomEdgeValues(1, 100);
        
        g2[0].exportGraphWeighted("genErdosRenyi30");        
        g2[1].exportGraphWeighted("genErdosRenyi100");        
        g2[2].exportGraphWeighted("genErdosRenyi500");
        
        g = g2[0].Dijkstra(g2[0].nodes.get(0));
        g.exportGraphUnWeighted("genErdosRenyi30_Dijkstra");
        
        g = g2[1].Dijkstra(g2[1].nodes.get(0));
        g.exportGraphUnWeighted("genErdosRenyi100_Dijkstra");
        
        g = g2[2].Dijkstra(g2[2].nodes.get(0));
        g.exportGraphUnWeighted("genErdosRenyi500_Dijkstra");
       
        Grafo g3[] = new Grafo[3];
        g3[0] = Grafo.genGeografico(30,  0.2, false, false);
        g3[1] = Grafo.genGeografico(100, 0.2, false, false);
        g3[2] = Grafo.genGeografico(500, 0.1, false, false);
        
        for(int i = 0; i < g3.length; i++) g3[i].RandomEdgeValues(1, 100);
       
        g3[0].exportGraphWeighted("genGeografico30");        
        g3[1].exportGraphWeighted("genGeografico100");
        g3[2].exportGraphWeighted("genGeografico500");        
        
        
        g = g3[0].Dijkstra(g3[0].nodes.get(0));
        g.exportGraphUnWeighted("genGeografico30_Dijkstra");
        
        g = g3[1].Dijkstra(g3[1].nodes.get(0));
        g.exportGraphUnWeighted("genGeografico100_Dijkstra");
        
        g = g3[2].Dijkstra(g3[2].nodes.get(0));
        g.exportGraphUnWeighted("genGeografico500_Dijkstra");
        
        Grafo g4[] = new Grafo[3];
        g4[0] = Grafo.genGilbert(30,  0.3, false, false);
        g4[1] = Grafo.genGilbert(100, 0.3, false, false);
        g4[2] = Grafo.genGilbert(500, 0.09, false, false);
        
        for(int i = 0; i < g4.length; i++) g4[i].RandomEdgeValues(1, 100);
        
        g4[0].exportGraphWeighted("genGilbert30");        
        g4[1].exportGraphWeighted("genGilbert100");        
        g4[2].exportGraphWeighted("genGilbert500");
        
        
        g = g4[0].Dijkstra(g4[0].nodes.get(0));
        g.exportGraphUnWeighted("genGilbert30_Dijkstra");
        
        g = g4[1].Dijkstra(g4[1].nodes.get(0));
        g.exportGraphUnWeighted("genGilbert100_Dijkstra");
        
        g = g4[2].Dijkstra(g4[2].nodes.get(0));
        g.exportGraphUnWeighted("genGilbert500_Dijkstra");
        */
    }
    
}
