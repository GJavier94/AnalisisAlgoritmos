package bibliotecagrafos;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;

class Pair{
    double x,y;

    public Pair(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
}

public class Grafo {
    
    int numNodos; // numero de nodos que tiene el grafo 
    int numAristas; // numero de aristas que tiene el grafo 
    boolean dirigido;  //Indica  si el grafo es dirigido o no lo es  es decir que para cada para u.v vemos si u-v y v-u
    ArrayList<ArrayList<Integer>> listaAjacencia = new ArrayList<>();
    
    ArrayList<Pair> coordinates = new ArrayList<>();
    
    public Grafo(int numNodos, int numAristas, boolean dirigido) {
        this.numNodos = numNodos;
        this.numAristas = numAristas;
        this.dirigido = dirigido;   
        for(int i = 0; i < numNodos; i++){
          
            listaAjacencia.add(new ArrayList<>());
        }
    }
    
    /*
    Este metodo permite agregar una arista al nodo 
    Parametro de entrada 
    
    retorno true si la agrego correctamente, false en otro caso 
    */
    public void addArista(int nodo1, int nodo2){
        // si el grafo  es dirigido o no dirigido  agregamos u-v
        (listaAjacencia.get(nodo1)).add(nodo2);
        // solo en el caso de que el grafo sea no dirigido se agrega v-u
        if(!dirigido) (listaAjacencia.get(nodo2)).add(nodo1);
        
    }
    
    /*
    Este metodo revisa si existe una arista entre el nodo1 y nodo2
    retorna true si existe, false en caso contrario 
    */
    public boolean checkArista(int nodo1, int nodo2 ){
        //obtenemos la lista de  nodos con  los que esta conectado el nodo1 
        // y revisamos si tiene conexion con el nodo 2
        ArrayList<Integer> listaNodo1 = listaAjacencia.get(nodo1);
        
        for(int i = 0; i < listaNodo1.size(); i++){
            if( listaNodo1.get(i) == nodo2 ) return true;
        }
        return false;
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
    Este metodo imprime la lista de adjacencia del grafo
    */
    public void print(){
        for(int i=0;i<listaAjacencia.size();i++){
            System.out.print(i+ ": ");
            for(int j=0;j<listaAjacencia.get(i).size();j++){
                System.out.print(listaAjacencia.get(i).get(j) + " " );
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
            g.addArista(u, v);
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
            if( probabilidad <= p) g.addArista(i, j);
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
                g.addArista(i, j);
            }
        }
        /*
        Luego para los vertices restantes checo para los nodos anteriores
        si puedo conectarlos o no dependiendo de su grado
        */
        for(int i = D; i < n; i++ ){           
            for(int j = 0; j < i ; j++){
                int gradoNodo = g.listaAjacencia.get(j).size();
                
                double probabilidad = g.getRandomFloat();
                double p = 1 - (double ) ( gradoNodo / d);
                if( probabilidad <= p) g.addArista(i, j);
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
            g.coordinates.add(new Pair(x,y));
            
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
                
                if( distance <= r)g.addArista(i, j);
            }
        }
        
        return g;
        
    }
    
    /*
    Exporta el grafo en formato csv
    */
    public  void exportGraph(String nameFile)
    {
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile +".csv"), "UTF-8")))
        {
           
           for(int i = 0; i < listaAjacencia.size(); i++){
               
               writer.write("" + (i + 1));
               for(int j = 0; j < listaAjacencia.get(i).size();j++){
                   writer.write(";" + (listaAjacencia.get(i).get(j) + 1) );
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
