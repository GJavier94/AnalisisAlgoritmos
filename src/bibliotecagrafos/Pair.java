
package bibliotecagrafos;

import java.util.Comparator;

public class Pair implements Comparable<Pair>{
    private int id;
    private double weight;

    public Pair(int id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override    
    public int hashCode() {        
        return this.id*1000000007 + (int)this.weight;
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (this.getId() == other.getId()  && this.getWeight() == other.getWeight())
            return true;
        return false;
    }
    
    @Override
    public int compareTo(Pair p2) {
        
        if (this.getWeight()< p2.getWeight()) return 1;// Devuelve un entero positivo si la altura de o1 es mayor que la de o2
        if (this.getWeight() > p2.getWeight()) return -1;
        return 0;
    }
    
}
