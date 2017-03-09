package jcl.com.gadgetshop.events;

import jcl.com.gadgetshop.data.dao.ShippingInfo;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class PostShippingEvent {
    ShippingInfo shippingInfo;

    public PostShippingEvent(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }
}
