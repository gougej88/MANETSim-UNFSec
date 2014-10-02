package com.main;
import com.sparsity.sparksee.gdb.*;

public class Main {

    public static void main(String[] args) throws java.io.IOException, java.lang.Exception {
        // write your code here
        SparkseeProperties.load("C:\\Users\\Jeff\\IdeaProjects\\MANETSim-UNFSec\\lib\\sparksee.cfg");
        SparkseeConfig cfg = new SparkseeConfig();
        Sparksee sparksee = new Sparksee(cfg);
        Database db = sparksee.create("HelloSparksee.gdb", "HelloSparksee");
        Session sess = db.newSession();
        Graph graph = sess.getGraph();
        // Use 'graph' to perform operations on the graph database
        sess.close();
        db.close();
        sparksee.close();

        //Create graph grid of nodes
        Node a = new Node(1);

        //Start at outside node

        //Search grid for content custodian

        //Need to know where content found

        //Print where content is found
    }
}
