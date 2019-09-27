package ca.concordia.encs.conquerdia.engine;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        ConquerdiaController conquerdia = new ConquerdiaController();
        conquerdia.start(new Scanner(System.in), System.out);
    }
}
