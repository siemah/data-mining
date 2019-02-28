package ml.dayenio.datamining.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by @siemah on 28/02/2019.
 */
public class GSP {

    private int minSupp;
    private String[] items;
    private HashMap<String, Integer> itemsSupp = new HashMap<>();

    public GSP(int minSupp, String[] items) {
        this.init(minSupp, items);
    }

    /**
     * assign some values to GSP vars
     * @param minSupp minimum support
     * @param items list of items
     */
    private void init(int minSupp, String[] items) {
        this.minSupp = minSupp;
        this.items = items;
        for (int i = 0; i < this.items.length; i++)
            this.itemsSupp.put(items[i], 0);
    }

    /**
     * calculate the redundancy of each item
     * @param itemsChains String represent a data items
     * @return HashMap key is item and value is number of redundancy
     */
    public GSP computeRedundancy (ArrayList<String> itemsChains) {
        for (String item:this.items) {
            itemsChains.forEach(itemsChain -> {
                int currentSupp;
                if( itemsChain.contains(item)) {
                    currentSupp = this.itemsSupp.get(item);
                    this.itemsSupp.put(item, currentSupp+1);
                }
            });
        }
        return this;
    }

    /**
     * getter of itemsSupp
     * @return
     */
    public HashMap<String, Integer> getItemsSupp(){
        return this.itemsSupp;
    }

    /**
     * delete all items has a redundancy value less than minimum support
     * @return  GSP instance (fluent pattern)
     */
    public GSP removeItemsLessThanMinSupp () {
        this.itemsSupp.forEach((s, integer) -> {
            if(integer < this.minSupp) this.itemsSupp.remove(s);
        });
        return this;
    }

    /**
     * calculate cartesian product
     * @return GSP (Fluent pattern)
     */
    public LinkedList<String> computeCartesianProduct() {
        LinkedList<String> result = new LinkedList<>();
        Set<String> items = this.itemsSupp.keySet();
        for (String currentItem1 : items) {
            for (String currentItem2 : items) {
                result.add(currentItem1+currentItem2);
            }
        }
        return result;
    }

    /**
     * set a minSupp (can use this method to clear a minSupp
     * by passing an empty "new" HashMap instance)
     * @param minSupp minimum support
     */
    public void setMinSupp (int minSupp) {
        this.minSupp = minSupp;
    }

}

@FunctionalInterface
interface Callback {
    String cb(String x, String y);
}