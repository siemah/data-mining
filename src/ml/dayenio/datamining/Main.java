package ml.dayenio.datamining;

import ml.dayenio.datamining.Controller.Controller;
import ml.dayenio.datamining.Controller.GSP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        int minimumSupport = 5;
        String[] items = { "c", "t", "g", "a" };

        GSP gsp = new GSP(minimumSupport, items);
        Controller controller = new Controller("bdd.txt");

        ArrayList<String> fl = controller.getItemsOfLine();

        LinkedList<String> result = gsp
                    .computeRedundancy(fl)
                    .removeItemsLessThanMinSupp()
                    .computeCartesianProduct();

    }
}
