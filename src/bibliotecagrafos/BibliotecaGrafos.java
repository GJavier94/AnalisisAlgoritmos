package bibliotecagrafos;

public class BibliotecaGrafos {

    public static void main(String[] args) {
        
        //GRAFO 1 n, d donde d = valor esperado de nodos ady por cada nodo
                       
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
        
        
        //Grafos  exactamente el numero de aristas
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
        
        
        //Grafos  exactamente el numero de aristas rectangulo 
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
        
        
        //Grafos  probabilidad de que dos nodos esten conectados
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
        
    }
    
}
