package bibliotecagrafos;

public class BibliotecaGrafos {

    public static void main(String[] args) {
        /*
        Grafo g1[] = new Grafo[3];
        g1[0] = Grafo.genBarabasiAlbert(30, 3 , false, false);
        g1[1] = Grafo.genBarabasiAlbert(100,5 , false, false);
        g1[2] = Grafo.genBarabasiAlbert(500,2 , false, false);
        
        g1[0].exportGraph("genBarabasiAlbert30");        
        g1[1].exportGraph("genBarabasiAlbert100");        
        g1[2].exportGraph("genBarabasiAlbert500");
        
        
                
        Grafo g2[] = new Grafo[3];
        g2[0] = Grafo.genErdosRenyi(30, 5, false, false);
        g2[1] = Grafo.genErdosRenyi(100, 20, false, false);
        g2[2] = Grafo.genErdosRenyi(500, 30, false, false);
        
        g2[0].exportGraph("genErdosRenyi30");        
        g2[1].exportGraph("genErdosRenyi100");        
        g2[2].exportGraph("genErdosRenyi500");
        
        
        */
        Grafo g3[] = new Grafo[3];
        //g3[0] = Grafo.genGeografico(30,  0.2, false, false);
        //g3[1] = Grafo.genGeografico(100, 0.05, false, false);
        g3[2] = Grafo.genGeografico(500, 0.01, false, false);
        
        //g3[0].exportGraph("genGeografico30");        
        //g3[1].exportGraph("genGeografico100");
        g3[2].exportGraph("genGeografico500");        
        
      /* 
        Grafo g4[] = new Grafo[3];
        g4[0] = Grafo.genGilbert(30,  0.3, false, false);
        g4[1] = Grafo.genGilbert(100, 0.1, false, false);
        g4[2] = Grafo.genGilbert(500, 0.001, false, false);
        
        g4[0].exportGraph("genGilbert30");        
        g4[1].exportGraph("genGilbert100");        
        g4[2].exportGraph("genGilbert500");
        */
        
        //30,100,500
    }
    
}
