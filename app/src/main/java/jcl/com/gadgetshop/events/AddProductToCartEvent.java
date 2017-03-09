package jcl.com.gadgetshop.events;

import jcl.com.gadgetshop.data.dao.OrderLine;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public class AddProductToCartEvent {
    OrderLine orderLine;

    public AddProductToCartEvent(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }
}
