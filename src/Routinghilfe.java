package GraphTool;

import java.util.List;

public class Routinghilfe {

    private Knoten knoten;
    private int distanz;
    private Knoten vorgaenger;

    public Routinghilfe(Knoten knoten, int distanz, Knoten vorgaenger){
        this.knoten = knoten;
        this.distanz = distanz;
        this.vorgaenger = vorgaenger;
    }
    public Knoten getKnoten(){
        return this.knoten;
    }
    public int getDistanz(){
        return this.distanz;
    }
    public Knoten getVorgaenger(){
        return this.vorgaenger;
    }
    public void setKnoten(Knoten k){
        this.knoten = k;
    }
    public void setDistanz(int d){
        this.distanz = d;
    }
    public void setVorgaenger(Knoten k){
        this.vorgaenger = k;
    }
    public static Routinghilfe getKleinsteDistanz(List<Routinghilfe> q){

        Routinghilfe minDistanz = null;

        for (Routinghilfe r : q){

            if (minDistanz == null || r.getDistanz() < minDistanz.getDistanz()){
                minDistanz = r;
            }
    }
    return minDistanz;
}
    
}
