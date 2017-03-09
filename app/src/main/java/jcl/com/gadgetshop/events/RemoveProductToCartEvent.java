package jcl.com.gadgetshop.events;

import jcl.com.gadgetshop.data.dao.Order;
import jcl.com.gadgetshop.data.dao.OrderLine;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public class RemoveProductToCartEvent {
    OrderLine orderLine;

    public RemoveProductToCartEvent(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }
}
