
package GraphTool;

import java.util.List;
import java.util.ArrayList;

public class Graph {

    private List<Knoten> knoten;
    private String id;

    public Graph(String id){
        this.id = id;
        this.knoten = new ArrayList<>();
    }
    public void addKnoten(Knoten knoten){
        this.knoten.add(knoten);
    }

    public List<Knoten> getKnoten(){
        return this.knoten;
    }
    public String getId(){
        return this.id;
    }
    public Knoten getKnotenByID(String id){

        for (Knoten k : knoten){
            if (id.equals(k.getId())){
                return k;
            }
        }
        return null;

    }
}
