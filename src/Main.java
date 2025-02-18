package GraphTool;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Graph g = CreateGraph.createFromNXG("/C:/Users/Rick/Desktop//dijkstra//testzwei.nxg");

        List<Routinghilfe> dijkstraApplied = Dijkstra.applyDijkstra(g, g.getKnotenByID("a"));
        System.out.println(Dijkstra.getKuerzesterWeg(dijkstraApplied, g.getKnotenByID("a"), g.getKnotenByID("b")));
    }
}
