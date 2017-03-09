package jcl.com.gadgetshop.events;

import jcl.com.gadgetshop.data.dao.PaymentInfo;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class PostPaymentEvent {
    PaymentInfo paymentInfo;

    public PostPaymentEvent(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }
}
