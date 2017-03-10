package jcl.com.gadgetshop.modules.checkout.payment;

import org.greenrobot.eventbus.EventBus;

import jcl.com.gadgetshop.data.dao.PaymentInfo;
import jcl.com.gadgetshop.events.OnNextEvent;
import jcl.com.gadgetshop.events.OnPreviousEvent;
import jcl.com.gadgetshop.events.PostPaymentEvent;
import jcl.com.gadgetshop.events.PostShippingEvent;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class PaymentInteractor implements PaymentMvp.Interactor {

    PaymentPresenter presenter;

    public PaymentInteractor(PaymentPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void postPaymentInfo(PaymentInfo paymentInfo) {
        EventBus.getDefault().postSticky(new PostPaymentEvent(paymentInfo));
        //Remove the existing paymentinfo
        EventBus.getDefault().removeStickyEvent(PostPaymentEvent.class);
        //POst new payment info
        EventBus.getDefault().postSticky(new PostPaymentEvent(paymentInfo));
        //Trigger next event
        EventBus.getDefault().postSticky(new OnNextEvent());
    }

    @Override
    public void postBackAction() {
        EventBus.getDefault().postSticky(new OnPreviousEvent());
    }
}
