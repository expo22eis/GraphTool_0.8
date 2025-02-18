package GraphTool;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CreateGraph {


    public static Graph createFromNXG(String filepath){

        try {
            // Erstelle ein ObjectMapper-Objekt
            ObjectMapper objectMapper = new ObjectMapper();
            List<Knoten> knotenListe = new ArrayList<>();

            // Lese die JSON-Datei ein
            JsonNode rootNode = objectMapper.readTree(new File(filepath));

            // Lese den Graphnamen
            String graphName = rootNode.get("graph").asText();

            // Lese die Knoten
            JsonNode nodesNode = rootNode.get("nodes");
            System.out.println("Knoten:");
            for (JsonNode node : nodesNode) {
                knotenListe.add(new Knoten(node.asText()));
            }

            // Lese die Kanten
            JsonNode edgesNode = rootNode.get("edges");
            System.out.println("Kanten:");
            for (JsonNode edge : edgesNode) {
                String from = edge.get("from").asText();
                String to = edge.get("to").asText();
                int weight = edge.get("weight").asInt();

                Knoten toObject = null;
                for (Knoten zielknoten : knotenListe){
                    if (to.equals(zielknoten.getId())){
                        toObject = zielknoten;
                        break;
                    }
                }

                for (Knoten k : knotenListe){

                    if (from.equals(k.getId())){
                        k.addVerbindung(toObject,weight);
                        break;
                    }
                }

            }

            Graph g = new Graph(graphName);

            for (Knoten k : knotenListe){
                g.addKnoten(k);
            }

            return g;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        
    }
}
