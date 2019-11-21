
package bibliotecagrafos;

public class TripletaArista implements Comparable<TripletaArista> {
    double First; // weight
    int Second; //  u 
    int Third; // v 

    public TripletaArista(double First, int Second, int Third) {
        this.First = First;
        this.Second = Second;
        this.Third = Third;
    }

    public double getFirst() {
        return First;
    }

    public int getSecond() {
        return Second;
    }

    public int getThird() {
        return Third;
    }

    public void setFirst(double First) {
        this.First = First;
    }

    public void setSecond(int Second) {
        this.Second = Second;
    }

    public void setThird(int Third) {
        this.Third = Third;
    }
    
    @Override    
    public int hashCode() {        
        return this.Second*1000000007 + this.Third;
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TripletaArista other = (TripletaArista) obj;
        if (
                this.getFirst()== other.getFirst()  &&
                this.getSecond()== other.getSecond()  &&
                this.getThird()== other.getThird()  
            ) return true;
        return false;
    }
    
    @Override
    public int compareTo(TripletaArista p2) {
        
        if (this.getFirst() > p2.getFirst()) return 1;// Devuelve un entero positivo si la altura de o1 es mayor que la de o2
        if (this.getFirst() < p2.getFirst()) return -1;
        return 0;
    }
    
}
