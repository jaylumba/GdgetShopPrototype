package jcl.com.gadgetshop.events;

import java.util.HashMap;

import jcl.com.gadgetshop.data.dao.OrderLine;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public class PostCartEvent {
    HashMap<Long, OrderLine> cart;

    public PostCartEvent(HashMap<Long, OrderLine> cart) {

        this.cart = cart;
    }

    public HashMap<Long, OrderLine> getCart() {
        return cart;
    }
}
