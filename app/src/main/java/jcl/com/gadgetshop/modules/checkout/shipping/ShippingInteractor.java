package jcl.com.gadgetshop.modules.checkout.shipping;

import org.greenrobot.eventbus.EventBus;

import jcl.com.gadgetshop.data.dao.ShippingInfo;
import jcl.com.gadgetshop.events.OnNextEvent;
import jcl.com.gadgetshop.events.PostShippingEvent;

/**
 * Created by jayan on 3/10/2017.
 */

public class ShippingInteractor implements ShippingMvp.Interactor {
    ShippingPresenter presenter;

    public ShippingInteractor(ShippingPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postShippingInfo(ShippingInfo shippingInfo) {
        //Remove the existing shippingInfo
        EventBus.getDefault().removeStickyEvent(PostShippingEvent.class);
        //POst new shipping info
        EventBus.getDefault().postSticky(new PostShippingEvent(shippingInfo));
        //Trigger next event
        EventBus.getDefault().postSticky(new OnNextEvent());
    }
}
