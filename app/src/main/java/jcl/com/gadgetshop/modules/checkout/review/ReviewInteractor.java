package jcl.com.gadgetshop.modules.checkout.review;

import org.greenrobot.eventbus.EventBus;

import jcl.com.gadgetshop.events.OnNextEvent;
import jcl.com.gadgetshop.events.OnPreviousEvent;
import jcl.com.gadgetshop.modules.checkout.CheckoutPresenter;

/**
 * Created by jayanthony.lumba on 3/10/2017.
 */

public class ReviewInteractor implements ReviewMvp.Interactor {
    ReviewPresenter presenter;

    public ReviewInteractor(ReviewPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void postPlaceOrder() {
        EventBus.getDefault().postSticky(new OnNextEvent());
    }

    @Override
    public void postBackAction() {
        EventBus.getDefault().postSticky(new OnPreviousEvent());
    }
}
