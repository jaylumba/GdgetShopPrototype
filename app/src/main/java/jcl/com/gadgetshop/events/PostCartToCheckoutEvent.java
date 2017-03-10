package jcl.com.gadgetshop.events;

import java.util.ArrayList;
import java.util.HashMap;

import jcl.com.gadgetshop.data.dao.OrderLine;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public class PostCartToCheckoutEvent {
    ArrayList<OrderLine> orderLines;

    public PostCartToCheckoutEvent(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }
}
