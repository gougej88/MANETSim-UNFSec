package com.main;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Node a = new Node(1);
        a.PowerDrain(50);
        System.out.println(a.BatteryLifeRemaining);
    }
}
