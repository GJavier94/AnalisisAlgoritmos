
package bibliotecagrafos;

public class Edge {
    int id1;
    int id2;
    int weight;

    public Edge(int id1, int id2, int weight) {
        this.id1 = id1;
        this.id2 = id2;
        this.weight = weight;
    }

    public int getId1() {
        return id1;
    }

    public int getId2() {
        return id2;
    }

    public int getWeight() {
        return weight;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
