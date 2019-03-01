package ml.dayenio.datamining;

import ml.dayenio.datamining.Controller.Controller;

/**
 * Main class program start from this class
 */
public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller("bdd.txt");
        controller.addDataToDB("type", "_id", "cttggcaaccttggccccagggaaag");

    }
}
