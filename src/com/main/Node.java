package com.main;

/**
 * Created by n00430588 on 9/24/2014.
 */
public class Node {
    int NodeID;
    int BatteryLifeRemaining;
    int[] routes;
    Content[] content;
    int cacheSize;
    String[] cache;
    String[] contentCustodians;

    public Node(int NodeID)
    {
        this.NodeID = NodeID;
        this.BatteryLifeRemaining = 100;
        this.cacheSize = 10;
        Content cache[] = new Content[10];
        Content content[] = new Content[1];



    }

    public int getNodeID()
    {
        return NodeID;
    }

    public void receiveData(Content in, int route)
    {
        //Store content in cache then send along path if not on this node
        PowerDrain(1);
    }

    public void sendData(Content out, int route)
    {
        //Send content to next route

    }

    public void addToCache(Content x)
    {
        //Add content to cache when new content is received
    }

    public int PowerDrain(int drain)
    {
        //
        BatteryLifeRemaining = BatteryLifeRemaining-drain;
        return BatteryLifeRemaining;
    }

    public void saveContent(Content stuff)
    {
        //Make this node a content custodian
    }
}
