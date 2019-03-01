package ml.dayenio.datamining;

import ml.dayenio.datamining.Controller.Controller;
import ml.dayenio.datamining.Controller.GSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        int minimumSupport = 6;
        LinkedList<String> items = new LinkedList<>();
        items.add("a");
        items.add("g");
        items.add("c");
        items.add("t");

        GSP gsp = new GSP();
        Controller controller = new Controller("bdd.txt");

        ArrayList<String> fl = controller.getItemsOfLine();

        LinkedList<String> f1 =
                gsp
                    .init(0, items)
                    .computeRedundancyIn(fl)
                    .removeItemsLessThanMinSupp()
                    .computeCartesianProduct();

        LinkedList<String> f2 =
                gsp
                    .init(minimumSupport, f1)
                    .computeRedundancyIn(fl)
                    .removeItemsLessThanMinSupp()
                    .computeCartesianProduct();

        f2.forEach(s -> System.out.println(s));

    }
}
