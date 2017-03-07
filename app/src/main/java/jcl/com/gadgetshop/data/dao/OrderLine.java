package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

@Entity
public class OrderLine {

    @Id(autoincrement = true) Long id;
    @Property Long productId;
    @Property int quantity;
    @Generated(hash = 549427702)
    public OrderLine(Long id, Long productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }
    @Generated(hash = 1925626461)
    public OrderLine() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getProductId() {
        return this.productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
