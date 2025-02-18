package GraphTool;

import java.util.HashMap;
import java.util.Map;

public class Knoten {

    private String id;
    private Map<Knoten, Integer> verbindungen;

    public Knoten(String id){
        this.id = id;
        this.verbindungen = new HashMap<>();
    }
    public void addVerbindung(Knoten v, int gewicht){
        this.verbindungen.put(v, gewicht);
    }
    public Map<Knoten, Integer>  getVerbindungen(){
        return this.verbindungen;
    }
    public String getId(){
        return this.id;
    }
    public int getVerbindungsgewicht(Knoten k){

        return verbindungen.get(k);
    }
    public boolean istVerbunden(Knoten k){

        return verbindungen.containsKey(k);
    }
    
}
