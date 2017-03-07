package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.ArrayList;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

@Entity
public class Order {

    @Id long id;
    @Property long userId;
    @Property long shippingInfo;
    @Property long paymentInfoId;
    @Property double totalPrice;
    @Property Date transactionDate;
    @Property String status;
    @Generated(hash = 362458431)
    public Order(long id, long userId, long shippingInfo, long paymentInfoId,
            double totalPrice, Date transactionDate, String status) {
        this.id = id;
        this.userId = userId;
        this.shippingInfo = shippingInfo;
        this.paymentInfoId = paymentInfoId;
        this.totalPrice = totalPrice;
        this.transactionDate = transactionDate;
        this.status = status;
    }
    @Generated(hash = 1105174599)
    public Order() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getShippingInfo() {
        return this.shippingInfo;
    }
    public void setShippingInfo(long shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
    public long getPaymentInfoId() {
        return this.paymentInfoId;
    }
    public void setPaymentInfoId(long paymentInfoId) {
        this.paymentInfoId = paymentInfoId;
    }
    public double getTotalPrice() {
        return this.totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Date getTransactionDate() {
        return this.transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
