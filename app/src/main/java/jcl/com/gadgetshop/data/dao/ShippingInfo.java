package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

@Entity
public class ShippingInfo {
    @Id(autoincrement = true) Long id;
    @Property String shipTo;
    @Property String address;
    @Property String contactNo;
    @Generated(hash = 430862797)
    public ShippingInfo(Long id, String shipTo, String address, String contactNo) {
        this.id = id;
        this.shipTo = shipTo;
        this.address = address;
        this.contactNo = contactNo;
    }
    @Generated(hash = 1362188477)
    public ShippingInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getShipTo() {
        return this.shipTo;
    }
    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContactNo() {
        return this.contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
