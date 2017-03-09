package jcl.com.gadgetshop.modules.checkout.shipping;

import org.greenrobot.eventbus.EventBus;

import jcl.com.gadgetshop.base.BasePresenter;
import jcl.com.gadgetshop.events.OnNextEvent;

/**
 * Created by jayan on 3/10/2017.
 */

public class ShippingPresenter extends BasePresenter implements ShippingMvp.Presenter {

    ShippingMvp.View view;
    ShippingInteractor interactor;

    public ShippingPresenter(ShippingMvp.View view) {
        this.view = view;
        this.interactor = new ShippingInteractor(this);
        attachView(view);
    }

    @Override
    public void onLoad() {
        view.initViews();
    }

    @Override
    public void next() {
        if (view.getFullname().isEmpty() || view.getAddress().isEmpty() || view.getContactNumber().isEmpty())
            view.showToast("Please complete all required fields!");
        else
            EventBus.getDefault().postSticky(new OnNextEvent());
    }
}
