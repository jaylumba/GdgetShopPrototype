package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */
@Entity
public class OrderMapping {
    @Unique @Property Long orderId;
    @Unique @Property Long orderLineId;
    @Generated(hash = 621030484)
    public OrderMapping(Long orderId, Long orderLineId) {
        this.orderId = orderId;
        this.orderLineId = orderLineId;
    }
    @Generated(hash = 1825965273)
    public OrderMapping() {
    }
    public Long getOrderId() {
        return this.orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getOrderLineId() {
        return this.orderLineId;
    }
    public void setOrderLineId(Long orderLineId) {
        this.orderLineId = orderLineId;
    }

}
