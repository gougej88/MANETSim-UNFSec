package com.main;

/**
 * Created by n00430588 on 9/24/2014.
 */
public class Content {
    //right now each node can only hold 1 piece of content
    int NodeCustodian;
    String content;

    public Content()
    {

    }

    public void AddContent(int NodeCustodian, String content)
    {
        this.NodeCustodian = NodeCustodian;
        this.content = content;
    }


    public String showContent(int NodeCustodian)
    {
        //Show the content stored on the node
        return content;
    }
}
