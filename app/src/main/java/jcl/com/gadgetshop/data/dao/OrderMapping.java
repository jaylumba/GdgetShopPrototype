package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */
@Entity
public class OrderMapping {
    @Unique @Property long orderId;
    @Unique @Property long orderLineId;
    @Generated(hash = 522012716)
    public OrderMapping(long orderId, long orderLineId) {
        this.orderId = orderId;
        this.orderLineId = orderLineId;
    }
    @Generated(hash = 1825965273)
    public OrderMapping() {
    }
    public long getOrderId() {
        return this.orderId;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    public long getOrderLineId() {
        return this.orderLineId;
    }
    public void setOrderLineId(long orderLineId) {
        this.orderLineId = orderLineId;
    }
}
