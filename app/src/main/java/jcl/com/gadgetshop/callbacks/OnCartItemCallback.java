package jcl.com.gadgetshop.callbacks;

import jcl.com.gadgetshop.data.dao.Order;
import jcl.com.gadgetshop.data.dao.OrderLine;
import jcl.com.gadgetshop.data.dao.Product;

/**
 * Created by jayanthony.lumba on 3/9/2017.
 */

public interface OnCartItemCallback {
    void onIncrease(OrderLine orderLine);
    void onDecrease(OrderLine orderLine);
    void onRemove(OrderLine orderLine);
}
