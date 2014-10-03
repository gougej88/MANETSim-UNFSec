package com.main;
import com.sparsity.sparksee.algorithms.SinglePairShortestPathDijkstra;
import com.sparsity.sparksee.gdb.*;

public class Main {

    public static void main(String[] args) throws java.io.IOException, java.lang.Exception {
        // write your code here
        //SparkseeProperties.load("C:\\Users\\Jeff\\IdeaProjects\\MANETSim-UNFSec\\lib\\sparksee.cfg");
        SparkseeProperties.load("C:\\Users\\n00430588\\IdeaProjects\\MANETSim\\lib\\sparksee.cfg");
        SparkseeConfig cfg = new SparkseeConfig();
        Sparksee sparksee = new Sparksee(cfg);
        Database db = sparksee.create("HelloSparksee.gdb", "HelloSparksee");
        Session sess = db.newSession();
        Graph graph = sess.getGraph();



        // Use 'graph' to perform operations on the graph database
        //Create Node Structure
        int nodeType = graph.newNodeType("Node");
        int nodeID = graph.newAttribute(nodeType, "ID", DataType.Long, AttributeKind.Unique);
        int nodeBatteryLifeRemaining = graph.newAttribute(nodeType, "BatteryLifeRemaining", DataType.Integer, AttributeKind.Indexed);
        int content = graph.newAttribute(nodeType, "Content", DataType.String, AttributeKind.Indexed);

        //Create Undirected edges
        int routeType = graph.newEdgeType("route",false,false);
        int routeWeight = graph.newAttribute(routeType, "weight", DataType.Integer, AttributeKind.Basic);

        Value value = new Value();
        long node1 = graph.newNode(nodeType);
        graph.setAttribute(node1, nodeID, value.setLong(1));
        graph.setAttribute(node1, nodeBatteryLifeRemaining, value.setInteger(100));
        graph.setAttribute(node1, content, value.setString("Content from node 1"));

        long node2 = graph.newNode(nodeType);
        graph.setAttribute(node2, nodeID, value.setLong(2));
        graph.setAttribute(node2, nodeBatteryLifeRemaining, value.setInteger(100));
        graph.setAttribute(node2, content, value.setString("Content from node 2"));

        long node3 = graph.newNode(nodeType);
        graph.setAttribute(node3, nodeID, value.setLong(3));
        graph.setAttribute(node3, nodeBatteryLifeRemaining, value.setInteger(100));
        graph.setAttribute(node3, content, value.setString("Content from node 3"));

        long node4 = graph.newNode(nodeType);
        graph.setAttribute(node4, nodeID, value.setLong(4));
        graph.setAttribute(node4, nodeBatteryLifeRemaining, value.setInteger(100));
        graph.setAttribute(node4, content, value.setString("Content from node 4"));

        long edge;

        edge = graph.newEdge(routeType,node1,node2);
        graph.setAttribute(edge, routeWeight, value.setInteger(1));

        edge = graph.newEdge(routeType,node2,node3);
        graph.setAttribute(edge, routeWeight, value.setInteger(1));

        edge = graph.newEdge(routeType,node3,node4);
        graph.setAttribute(edge, routeWeight, value.setInteger(1));

        SinglePairShortestPathDijkstra test = new SinglePairShortestPathDijkstra(sess,node1,node4);
        test.addAllNodeTypes();
        test.addAllEdgeTypes(EdgesDirection.Any);
        test.run();
        double hops = test.getCost();

        System.out.printf("Cost %.0f \n", hops);
        OIDList pathAsNodes = test.getPathAsNodes();
        OIDListIterator pathIt = pathAsNodes.iterator();
        while (pathIt.hasNext())
        {
            long nodeid = pathIt.next();
            System.out.println("Node: "+nodeid);
        }

        test.close();
        sess.close();
        db.close();
        sparksee.close();

        //Create graph grid of nodes
        //Node a = new Node(1);

        //Start at outside node

        //Search grid for content custodian

        //Need to know where content found

        //Print where content is found
    }
}
