package jcl.com.gadgetshop.modules.checkout.payment;

import jcl.com.gadgetshop.base.BaseMvp;
import jcl.com.gadgetshop.data.dao.PaymentInfo;
import jcl.com.gadgetshop.data.dao.ShippingInfo;

/**
 * Created by jayan on 3/10/2017.
 */

public class PaymentMvp {

    interface Interactor {
        void postPaymentInfo(PaymentInfo paymentInfo);
    }

    interface View extends BaseMvp.View {
        void initViews();
        String getCardholdersName();
        String getCreditCardNumber();
        String getExpiryDate();
        String getCvv();
    }

    interface Presenter extends BaseMvp.Presenter {
        void onLoad();
        void next();
    }

}
