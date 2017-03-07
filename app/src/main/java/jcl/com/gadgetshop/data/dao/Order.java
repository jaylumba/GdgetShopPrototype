package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */

@Entity
public class Order {

    @Id(autoincrement = true) Long id;
    @Property Long userId;
    @Property Long shippingInfo;
    @Property Long paymentInfoId;
    @Property double totalPrice;
    @Property Date transactionDate;
    @Property String status;
    @Generated(hash = 861031895)
    public Order(Long id, Long userId, Long shippingInfo, Long paymentInfoId,
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
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getShippingInfo() {
        return this.shippingInfo;
    }
    public void setShippingInfo(Long shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
    public Long getPaymentInfoId() {
        return this.paymentInfoId;
    }
    public void setPaymentInfoId(Long paymentInfoId) {
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
