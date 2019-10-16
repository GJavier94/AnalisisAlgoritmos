package bibliotecagrafos;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*; 


public class Grafo {
    
    int numNodos; // numero de nodos
    int numAristas; // numero de aristas 
    boolean dirigido;  //Indica  si el grafo es dirigido o no lo es  es decir que para cada para u.v vemos si u-v y v-u
    
    public static final int UNVISITED = -1;
    public static final int VISITED = 1;
    public static final int INF = 1000000000;
    
    
    ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Coordinate> coordinates = new ArrayList<>();
    
    ArrayList<Integer> dfs_num = new ArrayList<Integer>();
    
    
    
    public Grafo(int numNodos, int numAristas, boolean dirigido) {
        this.numNodos = numNodos;
        this.numAristas = numAristas;
        this.dirigido = dirigido;   
        for(int i = 0; i < numNodos; i++){
            adjList.add(new ArrayList<>());
            dfs_num.add(UNVISITED);
            nodes.add(new Node(i));
        }
        
    }
    
    /*
    Este metodo permite agregar una arista al nodo 
    Parametro de entrada 
    
    retorno true si la agrego correctamente, false en otro caso 
    */
    public void addArista(int nodo1, int nodo2, double weight){
        // si el grafo  es dirigido o no dirigido  agregamos u-v
        (adjList.get(nodo1)).add(new Pair( nodo2, weight ));
        // solo en el caso de que el grafo sea no dirigido se agrega v-u
        if(!dirigido && nodo1 != nodo2) (adjList.get(nodo2)).add( new Pair(nodo1, weight));
        
    }
    
    /*
    Este metodo revisa si existe una arista entre el nodo1 y nodo2
    retorna true si existe, false en caso contrario 
    */
    public boolean checkArista(int nodo1, int nodo2 ){
        
        ArrayList<Pair> listaNodo1 = adjList.get(nodo1);
        
        for(int i = 0; i < listaNodo1.size(); i++){
            Pair p = listaNodo1.get(i);
            if(  p.getId() == nodo2 ) return true;
        }
        return false;
    }
    
    public double getWeightArista(int nodo1, int nodo2 ){
              
        ArrayList<Pair> listaNodo1 = adjList.get(nodo1);
        
        for(int i = 0; i < listaNodo1.size(); i++){
            Pair p = listaNodo1.get(i);
            if(  p.getId() == nodo2 ) return p.getWeight();
        }
        return 0.0;
    }
    
    
    
    /*
    Genera un numero entero aleatorio entre 0 y n -1
    */
    public int getRandomNum(int n){
        return ThreadLocalRandom.current().nextInt( 0, n );
    }
    
    /*
    Genera un numero decimal  aleatorio entre 0 y 1
    */
    public double getRandomFloat(){
        return Math.random();

    }
    /*
    Genera un numero decimal  aleatorio entre min y max
    */
    
    public double getRandomFloat(double min, double max){
        return (Math.random() * ((max - min) + 1)) + min;
    }
    
   
    /*
    Este metodo imprime la lista de adjacencia del grafo
    */
    public void print(){
        for(int i=0;i<adjList.size();i++){
            System.out.print(i+ ": ");
            for(int j=0;j<adjList.get(i).size();j++){
                Pair p = adjList.get(i).get(j);
                System.out.print("(" +p.getId() + "," + p.getWeight()+ ")," );
            }
            System.out.println("");
        }
    }
    /*
    Metodo de generacion de grafo genErdosRenyi
    */
    public static Grafo genErdosRenyi(int n, int m, boolean dirigido, boolean auto){
        Grafo g = new Grafo(n,m, dirigido);
        /*
        genero aleatoriamente indices de nodos u y v 
        revisando que no exista previamente u-v y tambien si el grafo permite ciclos
        el ciclo termina cuando tenga las m aristas
        */
        int contador = 0;
        while( contador < m ){
            int u,v;
            u = g.getRandomNum(n);
            v = g.getRandomNum(n);
            if(u == v && !auto) continue;
            if(g.checkArista(u, v) )  continue;
            g.addArista(u, v, 0 );
            contador++;
        }
        
        return g;
    }
    
    /*
    Metodo de generacion de grafo genGilbert
    */
    public static Grafo genGilbert(int n, double p, boolean dirigido, boolean auto){
        Grafo g = new Grafo(n,0, dirigido);
        
        /*checo las n*n combinaciones de nodos y veo si puedo crear una arista probabilis
        ticamente*/
        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
              
            if( i == j && !auto) continue;
            if( g.checkArista(i, j)) continue;
            
            double probabilidad = g.getRandomFloat();
            if( probabilidad <= p) g.addArista(i, j, 0);
          }
        }
        return g;
    }
    
    
    
    /*
    Metodo de generacion de grafo genBarabasiAlbert
    */
    
    public static Grafo genBarabasiAlbert(int n, double d, boolean dirigido, boolean auto){
        Grafo g = new Grafo(n, 0, dirigido);
        
        int D = (int)d;
        //Por definicion los primeros D vertices tienen que conectarse
        for(int i = 0; i < D ; i++){
            for(int j = i + 1; j < D; j++){
                g.addArista(i, j, 0);
            }
        }
        /*
        Luego para los vertices restantes checo para los nodos anteriores
        si puedo conectarlos o no dependiendo de su grado
        */
        for(int i = D; i < n; i++ ){           
            for(int j = 0; j < i ; j++){
                int gradoNodo = g.adjList.get(j).size();
                
                double probabilidad = g.getRandomFloat();
                double p = 1 - (double ) ( gradoNodo / d);
                if( probabilidad <= p) g.addArista(i, j, 0);
            }
        }
        
        return g;
    }
   
    /*
    Metodo de generacion de grafo genGeografico
    */
    public static Grafo genGeografico(int n, double r, boolean dirigido, boolean auto){
        Grafo g = new Grafo(n,0,dirigido);
        
        //primero genero pares (x,y) entre 0 y 1 para cada uno de los nodos
        for(int i = 0; i < n ; i++){
            double x = g.getRandomFloat();
            double y = g.getRandomFloat();
            g.coordinates.add(new Coordinate(x,y));
            
        }
        
        // calculo  la distancia entre el nodo contra todos los nodos del grafo
        // si la distancia es menor o igual a r genero arista
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                if(i == j && !auto) continue;
                if(g.checkArista(i, j))continue;
                double distance = Math.sqrt(
                        (g.coordinates.get(i).x- g.coordinates.get(j).x)*
                        (g.coordinates.get(i).x- g.coordinates.get(j).x)
                        + 
                        (g.coordinates.get(i).y- g.coordinates.get(j).y)*
                        (g.coordinates.get(i).y- g.coordinates.get(j).y));
                
                if( distance <= r)g.addArista(i, j, 0);
            }
        }
        
        return g;
        
    }
    
    public Grafo BFS(int u ){
        int n = adjList.size();
        Grafo g = new Grafo(n,0,false);
        int[] dis = new int[n];
        
        for(int i = 0; i < adjList.size(); i++) dis[i] = INF;
        Queue<Integer> q = new LinkedList<>(); 
        q.add(u);
        dis[u] = 0;
	
        while(q.size() > 0 ){
                u = q.peek();
                q.poll();
                for(int i = 0; i < adjList.get(u).size(); i++){
                        int v = adjList.get(u).get(i).getId(); 
                        if( dis[v] >  dis[u] + 1){
                                dis[v] = dis[u] + 1;
                                q.add(v);
                                g.addArista(u, v, 0);
                        }
                }
        }
        return g;
    }
    
    public Grafo DFS_TREE_R(int u ){
        int n = adjList.size();
        Grafo g = new Grafo(n,0,false);
        DFS(u, g);
        dfs_num.clear();
        for(int i = 0; i < numNodos; i++) dfs_num.add(UNVISITED);
     
        return g;
    }
    
    public void DFS(int u, Grafo g ){
        dfs_num.set(u, VISITED);
        for(int j = 0; j <  adjList.get(u).size(); j++){
                int v = adjList.get(u).get(j).getId();
                if(dfs_num.get(v) == UNVISITED){
                    g.addArista(u, v, 0);
                    DFS(v,g);
                }
        }   
    }
    
    public Grafo DFS_TREE_I(int u ){
        int n = adjList.size();
        Grafo g = new Grafo(n,0,false);
        Stack<Integer> stack = new Stack<Integer>(); 

        dfs_num.set(u, VISITED);
        stack.push(u);
        
        while(!stack.empty()){
            u = stack.peek();
            stack.pop();
            for(int j = 0; j < adjList.get(u).size();j++){
                int v = adjList.get(u).get(j).getId();
                if(dfs_num.get(v) == UNVISITED){
                    g.addArista(u, v, 0);
                    dfs_num.set(v, VISITED);
                    stack.push(v);
                }
            }
        }
        dfs_num.clear();
        for(int i = 0; i < numNodos; i++) dfs_num.add(UNVISITED);
        
        return g;
    }
    
    
    
    
    void RandomEdgeValues(double min, double max) { 
        // recorremos la lista de adyacencia y le damos peso a las aristas
        HashMap<Pair,Double> m = new HashMap<Pair,Double>();
                
                
        for(int i = 0; i < adjList.size(); i++){
            for(int j = 0; j < adjList.get(i).size(); j++){
                int v = adjList.get(i).get(j).getId();                       
                if( i == v  ) continue;
                if(!dirigido && v < i ){                    
                    Pair temp = new Pair(v,i);                                        
                    double weight = m.get(temp);                  
                    adjList.get(i).get(j).setWeight(weight);
                    continue;
                }
                double w = getRandomFloat(min, max);
                adjList.get(i).get(j).setWeight(w);
                
                Pair temp = new Pair(i,v);
                m.put(temp,w );
                        
            }
        }
    }
    
    Grafo Dijkstra(Node s) {
        
        int n = adjList.size();
        Grafo g = new Grafo(n,0,false);
        
        double[] dis = new double[n];
        int[] parents = new int[n];
        
        for(int i = 0; i < adjList.size(); i++){
            dis[i] = INF;
            parents[i] = i;
        }   
        
        dis[s.getId()] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.offer( new Pair( s.getId(),0 ) );
        
        
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int u = top.getId(); double d = top.getWeight();
            
            if (d > dis[u] ) continue;
            for(int j = 0; j < adjList.get(u).size(); j++){
                Pair par = adjList.get(u).get(j);
                int v = par.getId();
                double w = par.getWeight();
                if( dis[u] + w < dis[v]){
                    parents[v] = u;
                    dis[v] = dis[u] + w;
                    pq.offer(new Pair(v,dis[v]));
                }
            }
            
        }
       
        g.nodes.get(s.getId()).setNameNode("nodo_" + s.getId() + "(0.00)");
        for(int i = 0; i < n ; i++){
            if(i == parents[i]) continue;
            g.addArista(i, parents[i], 0);
            g.nodes.get(i).setNameNode("nodo_" + i + "(" + 
                    String.format("%.2f", dis[i])
                    + ")");
        }
        
        return g;
    }

    
    
    
    /*
    Exporta el grafo en formato csv
    */
    public  void exportGraphWeighted(String nameFile)
    {
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile +".csv"), "UTF-8")))
        {   
            
            writer.write("source;target;weight\n");
            
            for(int i = 0 ; i < adjList.size(); i++){
                for(int j = 0; j < adjList.get(i).size(); j++){
                    int u = i;
                    int v = adjList.get(i).get(j).getId();
                    double w = adjList.get(i).get(j).getWeight();
                    writer.write( u + ";" + v  + ";" +  String.format("%.2f",  w) + "\n");
                }
            }
            
            
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    public  void exportGraphUnWeighted(String nameFile){
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile +".csv"), "UTF-8")))
        {           
           for(int i = 0; i < adjList.size(); i++){
               writer.write("" + nodes.get(i).getNameNode());
               for(int j = 0; j < adjList.get(i).size();j++){
                   Pair p = adjList.get(i).get(j);
                   int v = p.getId(); 
                   writer.write(";" + nodes.get(v).getNameNode() );
               }
               writer.write("\n");
           }
           
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

}