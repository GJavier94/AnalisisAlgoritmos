package bibliotecagrafos;

import java.util.*;

public class UnionFind {
    private Vector<Integer> p, rank, setSize;
    private int numSets;
    
    public UnionFind(int n){
        p = new Vector<Integer>(n);
        rank = new Vector<Integer>(n);
        setSize = new Vector<Integer>(n);
        numSets = n;
        for (int i = 0; i < n; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
      
    }
    
    public int findSet(int i){
        if(p.get(i)  == i) return i;
        else{
            int ret = findSet(p.get(i));
            p.set(i, ret);
            return ret;
        }
        
    }
    
    public boolean isSameSet(int i,int j){
        return findSet(i) == findSet(j);
    }
    
    public void unionSet(int i, int j){
        if(!isSameSet(i, j)){
            numSets--;
            int x = findSet(i);
            int y = findSet(j);
            if(rank.get(x) > rank.get(y)){
                p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y));
            }
            else{
                p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
            }
        }
    }
        
    public int numDisjointSets(){return numSets;}
    
    public int sizeOfSet(int i){
        return setSize.get(findSet(i));
    }
}
