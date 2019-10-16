package bibliotecagrafos;

public class Node {
    int id;
    String nameNode;

    public Node(int id, String nameNode) {
        this.id = id;
        this.nameNode = nameNode;
    }

    public Node(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getNameNode() {
        return nameNode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameNode(String nameNode) {
        this.nameNode = nameNode;
    }
    
}
