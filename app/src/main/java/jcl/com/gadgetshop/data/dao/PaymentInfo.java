package jcl.com.gadgetshop.data.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jayanthony.lumba on 3/7/2017.
 */
@Entity
public class PaymentInfo {
    @Id(autoincrement = true) Long id;
    @Property String cardHoldersName;
    @Property String cardNumber;
    @Property String expriryDate;
    @Property String cvv;
    @Generated(hash = 842179791)
    public PaymentInfo(Long id, String cardHoldersName, String cardNumber,
            String expriryDate, String cvv) {
        this.id = id;
        this.cardHoldersName = cardHoldersName;
        this.cardNumber = cardNumber;
        this.expriryDate = expriryDate;
        this.cvv = cvv;
    }
    @Generated(hash = 1812234567)
    public PaymentInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCardHoldersName() {
        return this.cardHoldersName;
    }
    public void setCardHoldersName(String cardHoldersName) {
        this.cardHoldersName = cardHoldersName;
    }
    public String getCardNumber() {
        return this.cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getExpriryDate() {
        return this.expriryDate;
    }
    public void setExpriryDate(String expriryDate) {
        this.expriryDate = expriryDate;
    }
    public String getCvv() {
        return this.cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}
