
package GraphTool;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Dijkstra {


    public static String getKuerzesterWeg(List<Routinghilfe> r, Knoten startknoten, Knoten endknoten){

        Routinghilfe endknoten_element = r.stream()
                .filter(s -> s.getKnoten().equals(endknoten))
                .findFirst()
                .orElse(null);

        if (endknoten_element == null){
            return "Kein Weg gefunden.";
        }
        if (endknoten_element.getVorgaenger() == null){
            return endknoten_element.getKnoten().getId();
        }
        else{
            return getKuerzesterWeg(r, startknoten, endknoten_element.getVorgaenger())+ " + "+endknoten_element.getKnoten().getId();
        }

    }
    public static List<Routinghilfe> applyDijkstra(Graph graph, Knoten startknoten) {

        List<Routinghilfe> q = new ArrayList<>();
        List<Routinghilfe> ergebnis = new ArrayList<>();
    
        for (Knoten k : graph.getKnoten()) {
            if (k.equals(startknoten)) {
                q.add(new Routinghilfe(k, 0, null));
            } else {
                q.add(new Routinghilfe(k, Integer.MAX_VALUE, null));
            }
        }
    
        while (!q.isEmpty()) {
    
            Routinghilfe u = Routinghilfe.getKleinsteDistanz(q);
            q.remove(u);
            ergebnis.add(u);
    
            for (Map.Entry<Knoten, Integer> adjacencyPair : u.getKnoten().getVerbindungen().entrySet()) {
    
                Knoten vKnoten = adjacencyPair.getKey();
                int weight = adjacencyPair.getValue();
    
                Routinghilfe vRouting = null;
                for (Routinghilfe r : q) {
                    if (r.getKnoten().equals(vKnoten)) {
                        vRouting = r;
                        break;
                    }
                }
    
                if (vRouting != null) {
                    int alternativeDistanz = u.getDistanz() + weight;
                    if (alternativeDistanz < vRouting.getDistanz()) {
                        vRouting.setDistanz(alternativeDistanz);
                        vRouting.setVorgaenger(u.getKnoten());
                    }
                }
            }
        }
return ergebnis;
    }
}


// funktion Dijkstra(V, E, start)
//     Für alle v ∈ V
//         Wenn v == start
//             distanz[v] := 0
//         andernfalls
//             distanz[v] := ∞
//         vorgänger[v] := null
//         Q.einfügen(v)
 
//     Solange Q nicht leer ist
//         u := kleinstes aus Q
//         Q.entferne(u)
//         Für alle (u, v) ∈ E mit v ∈ Q
//             Wenn distanz[u] + gewicht(u, v) < distanz[v]
//                 distanz[v] := distanz[u] + gewicht(u, v)
//                 vorgänger[v] := u
